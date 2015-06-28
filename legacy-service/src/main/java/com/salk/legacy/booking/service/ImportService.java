package com.salk.legacy.booking.service;

import java.util.List;

import com.salk.legacy.domain.Import;

public interface ImportService {
	public boolean addImport(Import i);

	public List<Import> getImports(Import i);

	public long getTotalImports(Import i);

	public Import findImport(String id);

	public Import findImportByExportNo(String exportNo);

	public boolean deleteImport(String ids);

	public boolean updateByKey(Import i);

	public List<Import> queryImportsByFacet(String importType);

}
