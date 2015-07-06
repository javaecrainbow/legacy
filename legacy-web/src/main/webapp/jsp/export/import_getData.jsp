<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch" action="/import/lookup/list.html"" method="post">
        <input type="hidden" name="pageSize" value="${model.pageSize}">
        <input type="hidden" name="pageSize" value="${model.pageSize}">
        <input type="hidden" name="pageCurrent" value="${model.pageCurrent}">
        <input type="hidden" name="orderField" value="${param.orderField}">
        <div class="bjui-searchBar">
            <label>入貨單號：</label><input type="text" id="importNo" name="importNo" class="form-control" size="10">&nbsp;
            <label>產品編號：</label><input type="text" id="importProdId" name="importProdId" class="form-control" size="10">&nbsp;
            <label>產品名稱：</label><input type="text" id="importName" name="importName" class="form-control" size="10">&nbsp;
           	 <label>入貨種類:</label>
            <select name="importType" data-toggle="selectpicker">
               <option value="">全部</option>
                <c:forEach items="${items}" var="item" varStatus="i" >
                              <option value="${item. typeName}">${item. typeName}</option>
                            </c:forEach>
            </select>&nbsp;
            <button type="submit" class="btn-default" data-icon="search">查詢</button>&nbsp;
            <a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查詢</a></li>
        </div>
    </form>
</div>
<div class="bjui-pageContent tableContent">
    <table data-toggle="tablefixed" data-width="100%">
        <thead>
            <tr>
                <th >入貨單號</th>
                 <th data-order-field="importName">產品編號</th>
                <th data-order-field="importName">產品名稱</th>
                <th data-order-field="importType">產品種類</th>
                <th data-order-field="importColor" >入貨顏色</th>
                <th data-order-field="importSize">入貨尺碼</th>
                <th width="74">操作</th>
            </tr>
        </thead>
        <tbody>
        
        <c:forEach items="${imports}" var="import" varStatus="i" >
                <td><c:out value="${import.importNo }"></c:out></td>
              <td><c:out value="${import.importProdId }"></c:out></td>
               <td><c:out value="${import.importName}"></c:out></td>
                <td><c:out value="${import.importType}"></c:out></td>
                <td><c:out value="${import.importColor}"></c:out></td>
                <td><c:out value="${import.importSize}"></c:out></td>
                <td>
                    <a href="javascript:;" data-toggle="lookupback" data-args="{pid:'${import.id }', importId:'${import.id }',exportType:'${import.importType }',exportColor:'${import.importColor }',exportSize:'${import.importSize }',exportName:'${import.importName }',exportProdId:'${import.importProdId }',nums:'${import.nums }'}" class="btn btn-blue" title="選擇本項" data-icon="check">選擇</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div class="bjui-pageFooter">
    <div class="pages">
        <span>每頁&nbsp;</span>
        <div class="selectPagesize">
            <select data-toggle="selectpicker" data-toggle-change="changepagesize">
                 <option value="10">10</option>
                <option value="30">30</option>
                <option value="60">60</option>
            </select>
        </div>
        <span>&nbsp;條，共 ${totalPage } 條</span>
    </div>
    <div class="pagination-box" data-toggle="pagination" data-total="${totalPage }" data-page-size="30" data-page-current="1">
    </div>
</div>
