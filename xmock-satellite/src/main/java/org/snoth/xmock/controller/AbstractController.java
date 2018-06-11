package org.snoth.xmock.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * Created by robbie on 21/02/2018.
 */
public abstract class AbstractController implements IController{

    protected class ControllerIdentifier {
        String path;
        String method;
    }

    protected final Map<ControllerIdentifier, String> endPoints;

    public AbstractController(Map<ControllerIdentifier, String> endPoints) {
        this.endPoints = endPoints;
    }

    @Override
    public void dispatch(HttpServletRequest request, HttpServletResponse response) throws Exception {
        endPoints.keySet()
                .stream()
                .filter(identifier -> identifier.method.equalsIgnoreCase(request.getMethod())
                        && identifier.path.equalsIgnoreCase(request.getServletPath()))
                .findFirst()
                .ifPresent(identifier -> {
                    try {
                        Method m = this.getClass().getMethod(endPoints.get(identifier), HttpServletRequest.class, HttpServletResponse.class);
                        m.invoke(this, request, response);
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                });
    }

    @Override
    public boolean hasMatchEndpoints(HttpServletRequest request, HttpServletResponse response) {
        return false;
    }
}
