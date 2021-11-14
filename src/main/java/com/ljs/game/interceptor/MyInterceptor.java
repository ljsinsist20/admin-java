package com.ljs.game.interceptor;

import cn.hutool.json.JSONUtil;
import com.ljs.game.exception.Assert;
import com.ljs.game.pojo.vo.LoginVO;
import com.ljs.game.result.R;
import com.ljs.game.result.ResponseEnum;
import com.ljs.game.utils.JwtUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.function.ServerResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class MyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        response.setHeader("Access-Control-Allow-Origin", "*");
//        response.setHeader("Access-Control-Allow-Headers", "Content-Type,Content-Length, Authorization, Accept,X-Requested-With");
//        response.setHeader("Access-Control-Allow-Methods", "PUT,POST,GET,DELETE,OPTIONS");

        if("OPTIONS".equals(request.getMethod().toUpperCase())) {
            return true;
        }

        String token = request.getHeader("X-Token");
        boolean flag = JwtUtils.checkToken(token);
        if (!flag) {
            response.reset();
            //设置编码格式
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
