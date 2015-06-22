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
                        <label for="j_custom_fname" class="control-label x85">用户名：</label>
                        <input type="text" name="userName" id="j_custom_fname" data-rule="required" size="30" value="${user.userName }">
                    </td>
                </tr>
                 <tr>
                    <td>
                        <label for="j_custom_fname" class="control-label x85">密码：</label>
                        <input type="text" name="password" id="j_custom_fname" data-rule="required" size="30" value="11111111">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="j_custom_sale" class="control-label x85">角色：</label>
                        <select name="role" id="j_custom_sale" data-toggle="selectpicker" data-rule="required" data-width="300" >
                            <option value="">高级管理员</option>
                            <option value="紅色">管理员</option>
                            <option value="黑色">普通员工</option>
                        </select>
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
