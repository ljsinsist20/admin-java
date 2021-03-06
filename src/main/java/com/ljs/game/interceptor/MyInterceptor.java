package com.ljs.game.interceptor;

import cn.hutool.json.JSONUtil;
import com.ljs.game.pojo.vo.LoginVO;
import com.ljs.game.result.ResponseEnum;
import com.ljs.game.utils.JwtUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class MyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if("OPTIONS".equals(request.getMethod().toUpperCase())) {
            return true;
        }

        String token = request.getHeader("X-Token");
        boolean flag = JwtUtils.checkToken(token);
        if (!flag) {
            response.reset();
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json;charset=UTF-8");
            response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
            response.setHeader("Access-Control-Allow-Methods", "*");
            response.setHeader("Access-Control-Max-Age", "3600");
            response.setHeader("Access-Control-Allow-Credentials", "true");

            PrintWriter pw = response.getWriter();
            LoginVO loginVO = new LoginVO(ResponseEnum.LOGIN_AUTH_ERROR.getCode(), "请重新登录");
            pw.write( JSONUtil.toJsonStr(loginVO));
            pw.flush();
            pw.close();
            return false;
        }
        return true;
    }
}
