package com.ljs.game.aop;

import com.ljs.game.pojo.log.OperationLog;
import com.ljs.game.service.OperationLogService;
import com.ljs.game.utils.JwtUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 切面处理类，操作日志异常日志记录处理
 */
@Aspect
@Component
public class OperLogAspect {

    @Autowired
    private OperationLogService operationLogService;

    /**
     * 设置操作日志切入点 记录操作日志 在注解的位置切入代码
     */
    @Pointcut("@annotation(com.ljs.game.aop.OperLog)")
    public void operLogPoinCut() {
    }

    /**
     * 正常返回通知，拦截用户操作日志，连接点正常执行完成后执行， 如果连接点抛出异常，则不会执行
     *
     * @param joinPoint 切入点
     * @param keys      返回结果
     */
    @AfterReturning(value = "operLogPoinCut()", returning = "keys")
    public void saveOperLog(JoinPoint joinPoint, Object keys) {
        // 获取RequestAttributes
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        // 从获取RequestAttributes中获取HttpServletRequest的信息
        HttpServletRequest request = (HttpServletRequest) requestAttributes
                .resolveReference(RequestAttributes.REFERENCE_REQUEST);
        String token = request.getHeader("X-Token");
        String userName = JwtUtils.getUserName(token);
        OperationLog operlog = new OperationLog();
        operlog.setDesc(userName); // 操作用户描述
        try {
            // 从切面织入点处通过反射机制获取织入点处的方法
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            // 获取切入点所在的方法
            Method method = signature.getMethod();
            // 获取操作
            OperLog opLog = method.getAnnotation(OperLog.class);
            if (opLog != null) {
                String operModul = opLog.operModul();
                String operType = opLog.operType();
                operlog.setModul(operModul); // 操作模块
                operlog.setType(operType); // 操作类型
            }
            operlog.setCreateTime(LocalDateTime.now()); // 创建时间
            operationLogService.insert(operlog);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
