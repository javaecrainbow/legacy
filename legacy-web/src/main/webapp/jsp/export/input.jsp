<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
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
    <form action="/demo/legacy-sport/export.html"" id="j_custom_form" data-toggle="validate" data-alertmsg="false">
        <table class="table table-condensed table-hover" width="100%">
            <tbody>
              <tr>
                    <td>
                        <label for="j_custom_fname" class="control-label x85">出貨單號：</label>
                        <input type="text" name="exportNo" id="j_custom_fname" data-rule="required" size="30" value="${exports.exportNo }">
                    </td>
                </tr>
                 <tr>
                    <td>
                        <label for="j_custom_fname" class="control-label x85">產品種類：</label>
                        <input type="text" name="exportType" id="j_custom_fname" data-rule="required" size="30" value="${exports.exportType }">
                    </td>
                </tr>
                <tr>
                 <td>
                        <label for="j_custom_birthday" class="control-label x85">出貨日期：</label>
                        <input type="text" name="exportDate" id="j_custom_birthday" data-toggle="datepicker" data-rule="required;date" size="30" value="<fmt:formatDate value='${exports.exportDate}' pattern='yyyy-MM-dd' />">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="j_custom_sale" class="control-label x85">出貨顏色：</label>
                        <select name="exportColor" id="j_custom_sale" data-toggle="selectpicker" data-rule="required" data-width="300" value="${exports.exportColor }">
                            <option value="">全部</option>
                            <option value="紅色">紅色</option>
                            <option value="黑色">黑色</option>
                        </select>
                    </td>
                </tr>
              <tr>
                    <td>
                        <label for="j_custom_sale" class="control-label x85">出貨尺碼：</label>
                        <select name="exportSize" id="j_custom_sale" data-toggle="selectpicker" data-rule="required" data-width="300" value="${exports.exportSize }">
                           <option value="XXL">XXL</option>
                              <option value="XL">XL</option>
                               <option value="S">S</option>
                               <option value="M">M</option>
                        </select>
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
