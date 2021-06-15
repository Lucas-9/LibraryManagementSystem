package top.lucas9.utils;


import top.lucas9.exception.AuthenticationException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.List;

/**
 * @author lucas
 */
public class AuthenticateUtil {
    public static void hasRole(HttpServletRequest request, String userRole)  {
        HttpSession session = request.getSession();
        String system_role = (String)session.getAttribute("ROLE");
        if (null == system_role || !system_role.equals(userRole)) {
            // 抛出权限异常，状态码返回401，前端跳转登录页面
            throw new AuthenticationException("没有权限，请先登录");
        }
    }
    public static void hasRoles(HttpServletRequest request, List<String> roles)  {
        HttpSession session = request.getSession();
        String system_role = (String)session.getAttribute("ROLE");
        if (null == system_role) {
            // 抛出权限异常，状态码返回401，前端跳转登录页面
            throw new AuthenticationException("没有权限，请先登录");
        }
        for (String role : roles) {
            if (role.equals(system_role)) {
                return;
            }
        }
        throw new AuthenticationException("没有权限，请先登录");
    }
    public static void logged(HttpServletRequest request)  {
        HttpSession session = request.getSession();
        String system_role = (String)session.getAttribute("ROLE");
        if (null == system_role) {
            throw new AuthenticationException("没有权限，请先登录");
        }
    }

    /**
     * 不是本人或相应管理员，则抛出异常
     * @param request
     * @param username
     * @param userRole
     */
    public static void isOneselfOrManager(HttpServletRequest request, String username, String userRole) {
        HttpSession session = request.getSession();
        String system_name = (String)session.getAttribute("USER_NAME");
        String system_role = (String)session.getAttribute("ROLE");
        if (null == system_name || null == system_role) {
            throw new AuthenticationException("没有权限，请先登录");
        }
        if (!system_name.equals(username) && !system_role.equals(userRole)) {
            throw new AuthenticationException("没有权限，操作失败");
        }
    }


    public static void logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Enumeration<String> enumeration = session.getAttributeNames();
        while (enumeration.hasMoreElements()) {
            String key = enumeration.nextElement();
            session.removeAttribute(key);
        }
    }

    public static boolean isSuperAdmin(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String system_role = (String)session.getAttribute("ROLE");
        if (null != system_role && "SUPER_ADMIN".equals(system_role)) {
            return true;
        }
        return false;
    }
    public static Boolean isAdmin(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String system_role = (String)session.getAttribute("ROLE");
        if (null != system_role && "ADMIN".equals(system_role)) {
            return true;
        }
        return false;
    }
}
