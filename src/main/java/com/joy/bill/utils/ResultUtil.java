package com.joy.bill.utils;

/**
 * Created by joy on 2018/3/29.
 */
public class ResultUtil {



    public static Result success(){
        return success(null);
    }

    public static Result success(Object data){
        Result result = new Result();

        result.setCode(0);
        result.setMessage("成功");
        result.setData(data);
        return result;
    }



    public static Result fail(int code,String message){
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);
        result.setData(null);
        return result;
    }



}
