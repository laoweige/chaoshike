<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<c:if test="${!cdnMode}">
    <script src="http://img01.zhaopin.cn/2014/money/scripts/module/calendar-yui.js"  charset="utf-8"></script>
    <script src="http://img01.zhaopin.cn/2014/money/scripts/module/calendar-def.js"></script>
    <script async="" src="http://img01.zhaopin.cn/2014/money/scripts/module/combo.js"  charset="utf-8"></script>
    <script async="" src="http://img01.zhaopin.cn/2014/money/scripts/module/combo_002.js"  charset="utf-8"></script>
</c:if>
<c:if test="${cdnMode}">
    <script src="http://img01.zhaopin.cn/2014/money/scripts/module/calendar-yui-line.js"  charset="utf-8"></script>
    <script src="http://img01.zhaopin.cn/2014/money/scripts/module/calendar-def-line.js"></script>
</c:if>
    <div id="search" >
    <label class='condition-label-cs'>预定推广时间：</label>
    <ul id="yui_3_5_1_1_1407323479351_25">
        <li id="yui_3_5_1_1_1407323479351_24" style="margin: 0px">
            <div id="yui_3_5_1_1_1407323479351_74" class="calendar-input-wrap">
                <span id="yui_3_5_1_1_1407323479351_73" class="calendar-start-icon trigger-icon-yui_3_5_1_1_1407323479351_18"></span>
                <input id="J_DepDate" class="f-text trigger-node-yui_3_5_1_1_1407323479351_18"
                type="text"  />
            </div>
        </li>
        <li id="yui_3_5_1_1_1407323479351_29" style="margin:auto 10px;">
            <div class="calendar-input-wrap">
                <span class="calendar-end-icon trigger-icon-yui_3_5_1_1_1407323479351_18"></span>
                <input id="J_EndDate"  class="f-text trigger-node-yui_3_5_1_1_1407323479351_18"
                type="text"  />
            </div>
        </li>
        <li id="yui_3_5_1_1_1407323479351_56">
            <a href='javascript:void(0);'>查看报价和库存</a>
        </li>
    </ul>
</div>



