package fz.fxq.user.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 实现Web层的日志切面
 */
@Aspect
@Component
public class ControllerLogAop {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    ThreadLocal<Long> startTime = new ThreadLocal<Long>();

    /**
     * 定义一个切入点.
     * 解释下：
     * <p>
     * ~ 第一个 * 代表任意修饰符及任意返回值.
     * ~ 第二个 * 任意包名
     * ~ 第三个 * 代表任意方法.
     * ~ 第四个 * 定义在web包或者子包
     * ~ 第五个 * 任意方法
     * ~ .. 匹配任意数量的参数.
     */
    @Pointcut("execution(public * fz.fxq.user.controller..*.*(..))")
    public void executeController() {
    }

    @Before("executeController()")
    public void doBefore(JoinPoint joinPoint) throws Exception {
        startTime.set(System.currentTimeMillis());

        log.info("---------------接收到请求，记录请求内容------------");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpServletResponse response = attributes.getResponse();
        String classType = joinPoint.getTarget().getClass().getName();
        Class<?> clazz = Class.forName(classType);

        Map mapParam = JsonHelp.getReqFormMap();
        String url = request.getRequestURL().toString();
        String httpMeth = request.getMethod();
        String ip = JsonHelp.getIpAddr();
        String classFn = joinPoint.getSignature().getName();
        String classMeth = joinPoint.getSignature().getDeclaringTypeName() + "." + classFn;

        //这一步获取到的方法有可能是代理方法也有可能是真实方法
        Method m = ((MethodSignature) joinPoint.getSignature()).getMethod();
        //判断代理对象本身是否是连接点所在的目标对象，不是的话就要通过反射重新获取真实方法
        if (joinPoint.getThis().getClass() != joinPoint.getTarget().getClass()) {
//            m = ReflectUtil.getMethod(joinPoint.getTarget().getClass(), m.getName(), m.getParameterTypes());
        }
        //通过真实方法获取该方法的参数名称
        LocalVariableTableParameterNameDiscoverer paramNames = new LocalVariableTableParameterNameDiscoverer();
        String[] parameterNames = paramNames.getParameterNames(m);
        //获取连接点方法运行时的入参列表
        Object[] args = joinPoint.getArgs();
        //将参数名称与入参值一一对应起来
        Map<String, Object> params = new HashMap<>();
        for (int i = 0; i < parameterNames.length; i++) {
            if (args[i] == null || args[i].getClass().toString().contains("HttpServletResponse")
                    || args[i].getClass().toString().contains("HttpServletRequest")
                    || args[i].getClass().toString().contains("MultipartHttpServletRequest")
                    || args[i].getClass().toString().contains("HttpSession")
                    || args[i].getClass().toString().contains("BindingResult")) {
                continue;
            }
            params.put(parameterNames[i], args[i]);
        }
        String strParam = params.size() > 0 ? new JSONObject(params).toString() : mapParam.toString();

        log.info(" URL          : " + url);
        log.info(" HTTP_METHOD  : " + httpMeth);
        log.info(" IP           : " + ip);
        log.info(" CLASS_METHOD : " + classMeth);
        log.info(" REQ_PARAM    : " + strParam);
    }

    @AfterReturning("executeController()")
    public void doAfterReturning(JoinPoint joinPoint) {
        HttpServletRequest request = JsonHelp.getRequest();
        // 记录下请求内容
        String strFormMap = JsonHelp.getReqFormMap().toString();
        String url = request.getRequestURL().toString();
        String httpMeth = request.getMethod();
        String ip = JsonHelp.getIpAddr();
        String classFn = joinPoint.getSignature().getName();
        String classMeth = joinPoint.getSignature().getDeclaringTypeName() + "." + classFn;
        log.info("URL : " + url);
        log.info("HTTP_METHOD : " + httpMeth);
        log.info("IP : " + ip);
        log.info("CLASS_METHOD : " + classMeth);
        log.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));

        log.info("REQ_PARAM:{}", strFormMap);
        log.info("处理请求 {} 耗时 {} 毫秒", classMeth, (System.currentTimeMillis() - startTime.get()));
    }

}