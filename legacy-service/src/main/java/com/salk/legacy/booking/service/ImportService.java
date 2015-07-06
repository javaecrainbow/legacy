package com.salk.legacy.booking.service;

import java.util.List;

import com.salk.legacy.domain.Import;
import com.salk.legacy.domain.Page;

public interface ImportService {
	public boolean addImport(Import i);

	public List<Import> getImports(Import i);

	public List<Import> getImportsByPage(Import i, Page page);

	public List<Import> getProdNameByPage(Import i, Page page);

	public long getTotalProdNameByPage(Import i);

	public long getTotalImports(Import i);

	public Import findImport(String id);

	public Import findImportByExportNo(String exportNo);

	public boolean deleteImport(String ids);

	public boolean updateByKey(Import i) throws Exception;

	public List<Import> queryImportsByFacet(String importType);

}
