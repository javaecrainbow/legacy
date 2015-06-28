<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch" action="/import/lookup/list.html"" method="post">
        <input type="hidden" name="pageCurrent" value="1">
        <input type="hidden" name="pageSize" value="${model.pageSize}">
        <input type="hidden" name="orderField" value="${param.orderField}">
        <div class="bjui-searchBar">
            <label>產品單號：</label><input type="text" id="importNo" name="importNo" class="form-control" size="10">&nbsp;
            <label>產品名稱：</label><input type="text" id="importName" name="importName" class="form-control" size="10">&nbsp;
           	 <label>入貨種類:</label>
            <select name="importType" data-toggle="selectpicker">
               <option value="">全部</option>
                <c:forEach items="${items}" var="item" varStatus="i" >
                              <option value="${item. typeName}">${item. typeName}</option>
                            </c:forEach>
            </select>&nbsp;
            <button type="submit" class="btn-default" data-icon="search">查询</button>&nbsp;
            <a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a></li>
            <div class="pull-right">
                <button type="button" class="btn-blue" data-toggle="lookupback" data-lookupid="ids" data-warn="请至少选择一项职业" data-icon="check-square-o">选择选中</button>
            </div>
        </div>
    </form>
</div>
<div class="bjui-pageContent tableContent">
    <table data-toggle="tablefixed" data-width="100%">
        <thead>
            <tr>
                <th data-order-field="importNo">入貨單號</th>
                <th data-order-field="importName">產品名稱</th>
                <th data-order-field="importType">產品種類</th>
                <th data-order-field="importDate">入貨日期</th>
                <th data-order-field="importColor" >入貨顏色</th>
                <th data-order-field="importSize">入貨尺碼</th>
                <th data-order-field="updaterName">入貨人員</th>
                <th data-order-field="updateTime">入貨時間</th>
                <th data-order-field="remark">備註</th>
                <th width="74">操作</th>
            </tr>
        </thead>
        <tbody>
        
        <c:forEach items="${imports}" var="import" varStatus="i" >
                <td><c:out value="${import.importNo }"></c:out></td>
               <td><c:out value="${import.importName}"></c:out></td>
                <td><c:out value="${import.importType}"></c:out></td>
                <td><fmt:formatDate value="${import.importDate}" pattern="yyyy-MM-dd" /></td>
                <td><c:out value="${import.importColor}"></c:out></td>
                <td><c:out value="${import.importSize}"></c:out></td>
                 <td><c:out value="${import.updaterName}"></c:out></td>
                <td><fmt:formatDate value="${import.updateTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
                <td><c:out value="${import.remark}"></c:out></td>
                <td>
                    <a href="javascript:;" data-toggle="lookupback" data-args="{pid:'${import.id }', exportNo:'${import.importNo }',exportType:'${import.importType }',exportColor:'${import.importColor }',exportSize:'${import.importSize }',exportName:'${import.importName }'}" class="btn btn-blue" title="选择本项" data-icon="check">选择</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div class="bjui-pageFooter">
    <div class="pages">
        <span>每页&nbsp;</span>
        <div class="selectPagesize">
            <select data-toggle="selectpicker" data-toggle-change="changepagesize">
                 <option value="10">10</option>
                <option value="30">30</option>
                <option value="60">60</option>
            </select>
        </div>
        <span>&nbsp;条，共 ${totalPage } 条</span>
    </div>
    <div class="pagination-box" data-toggle="pagination" data-total="${totalPage }" data-page-size="10" data-page-current="1">
    </div>
</div>
