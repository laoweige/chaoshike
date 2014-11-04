package com.chaoshi.validator;

import com.chaoshi.common.CommonUtil;

import java.util.regex.Pattern;

/**
 * Created by kehui.xu on 9/17.
 */
public class ParameterRules {

    private static String defaultSplit = ";";

    /**
     * 验证参数格式
     * @param parameter 请求参数
     * @return
     */
    public static boolean paramValidation(String parameter){
        if (CommonUtil.isNullOrEmpty(parameter)) {
            return false;
        }
        String[] parts = parameter.split("_");
        if (parts.length == 4) {
            if (intValidation(parts[1]) && intValidation(parts[3])) {
                return true;
            }
        }
        return false;
    }

    /**
     * int类型验证
     * @param str
     * @return
     */
    public static boolean intValidation(String str) {
        if (CommonUtil.isNullOrEmpty(str)) {
            return false;
        }
        try{
            //若是数字，则可以转换，否则会出现异常
            Integer.parseInt(str);
        }catch(Exception e){
            return false;
        }
        return true;
    }

    /**
     * 多个Int类型验证
     * @param strs
     * @param split
     * @return
     */
    public static boolean intListValidation(String strs, String split) {
        if (CommonUtil.isNullOrEmpty(split)) {
            split = defaultSplit;
        }
        if (CommonUtil.isNullOrEmpty(strs)){
            return false;
        }
        for (String str : strs.split(split)) {
            if (!intValidation(str)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Long类型验证
     * @param str
     * @return
     */
    public static boolean longValidation(String str) {
        if (CommonUtil.isNullOrEmpty(str)) {
            return false;
        }
        try{
            //若是数字，则可以转换，否则会出现异常
            Long.parseLong(str);
        }catch(Exception e){
            return false;
        }
        return true;
    }

    /**
     * 多个Long类型验证
     * @param strs
     * @param split
     * @return
     */
    public static boolean longListValidation(String strs, String split) {
        if (CommonUtil.isNullOrEmpty(split)) {
            split = defaultSplit;
        }
        if (CommonUtil.isNullOrEmpty(strs)){
            return false;
        }
        for (String str : strs.split(split)) {
            if (!longValidation(str)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Float类型验证
     * @param str
     * @return
     */
    public static boolean floatValidation(String str) {
        if (CommonUtil.isNullOrEmpty(str)) {
            return false;
        }
        try{
            //若是数字，则可以转换，否则会出现异常
            Float.parseFloat(str);
        }catch(Exception e){
            return false;
        }
        return true;
    }

    /**
     * 多个Float类型验证
     * @param strs
     * @param split
     * @return
     */
    public static boolean floatListValidation(String strs, String split) {
        if (CommonUtil.isNullOrEmpty(split)) {
            split = defaultSplit;
        }
        if (CommonUtil.isNullOrEmpty(strs)){
            return false;
        }
        for (String str : strs.split(split)) {
            if (!floatValidation(str)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 数字和字母验证
     * @param str
     * @return
     */
    public static boolean NumberLetterValidation(String str) {
        if (CommonUtil.isNullOrEmpty(str)){
            return false;
        }
        Pattern numLetterPatt = Pattern.compile("^[a-zA-Z0-9]+$");
        return numLetterPatt.matcher(str).matches();
    }

    /**
     * 多个数字和字母验证
     * @param strs
     * @param split
     * @return
     */
    public static boolean NumberLetterListValidation(String strs, String split) {
        if (CommonUtil.isNullOrEmpty(split)) {
            split = defaultSplit;
        }
        if (CommonUtil.isNullOrEmpty(strs)){
            return false;
        }
        for (String str : strs.split(split)) {
            if (!NumberLetterValidation(str)) {
                return false;
            }
        }
        return true;
    }
}
