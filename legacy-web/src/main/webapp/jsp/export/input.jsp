<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script type="text/javascript">
function pic_upload_success(file, data) {
    var json = $.parseJSON(data)
    
    $(this).bjuiajax('ajaxDone', json)
    if (json[BJUI.keys.statusCode] == BJUI.statusCode.ok) {
        $('#j_custom_pic').val(json.filename).trigger('validate')
        $('#j_custom_span_pic').html('<img src="'+ json.filename +'" width="100" />')
    }
}
function do_OK(json, $form) {
    console.log(json)
    console.log($form)
}
</script>
<div class="bjui-pageContent">
    <form action="/export/export.html"" id="j_custom_form" data-toggle="validate" data-alertmsg="false">
        <table class="table table-condensed table-hover" width="100%">
        <input type="hidden" name="importId" id="j_custom_fname"/>
        <input type="hidden" name="id" value="${exports.id }"/>
            <tbody>
              <tr>
                    <td>
                        <label for="j_custom_fname" class="control-label x85">出貨單號：</label>
                        <input type="text" name="exportNo" id="j_custom_fname" data-rule="required;integer;length[5]" size="30" value="${exports.exportNo }"/>
                        
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="j_custom_fname" class="control-label x85">產品編號：</label>
                        <input type="text" name="exportProdId" id="exportProdId" data-rule="required;num_and_leters;length[9]" size="30" value="${exports.exportProdId }" data-toggle="lookup" data-url="/import/lookup/list.html" data-group="" data-width="900" data-height="400">
                    </td>
                </tr>
                 <tr>
                    <td>
                        <label for="j_custom_fname" class="control-label x85">產品名稱：</label>
                        <input type="text" name="exportName" id="exportName" data-rule="required"  size="30" value="${exports.exportName }">
                    </td>
                </tr>
                 <tr>
                    <td>
                        <label for="j_custom_fname" class="control-label x85">產品種類：</label>
                    	<select name="exportType" id="exportType" data-toggle="selectpicker" data-rule="required" data-width="300" data_show="${exports.exportType }">
                          <c:forEach items="${items}" var="item" varStatus="i" >
                              <option value="${item. typeName}">${item. typeName}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                 <td>
                        <label for="j_custom_birthday" class="control-label x85">出貨日期：</label>
                        <input type="text" name="exportDate" id="j_custom_birthday" data-toggle="datepicker"  data-rule="required;date" size="30" value="${exports.strExportDate}">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="j_custom_sale" class="control-label x85">出貨顏色：</label>
                        <select name="exportColor" id="exportColor" data-toggle="selectpicker" data-rule="required" data-width="300" value="${exports.exportColor }">
                            <c:forEach items="${colors}" var="color" varStatus="i" >
                              <option value="${color}">${color}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
              <tr>
                    <td>
                        <label for="j_custom_sale" class="control-label x85">出貨尺碼：</label>
                        <select name="exportSize" id="exportSize" data-toggle="selectpicker" data-rule="required" data-width="300" value="${exports.exportSize }">
                          <c:forEach items="${sizes}" var="size" varStatus="i" >
                              <option value="${size}">${size}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                 <tr>
                    <td>
                        <label for="j_custom_fname" class="control-label x85">數量：</label>
                        <input type="text" name="nums" id="nums" data-rule="required;integer" size="30" value="${exports.nums }">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="j_custom_note" class="control-label x85">備註：</label>
                        <textarea name="remark" id="j_custom_note" data-toggle="autoheight" cols="60" rows="5"></textarea>
                    </td>
                </tr>
            </tbody>
        </table>
    </form>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close" data-icon="close">取消</button></li>
        <li><button type="submit" class="btn-default" data-icon="save">保存</button></li>
    </ul>
</div>
