package com.salk.legacy.booking.service;

import java.util.List;

import com.salk.legacy.domain.Booking;
import com.salk.legacy.domain.Export;
import com.salk.legacy.domain.Import;

public interface ExportService {
	public boolean addExport(Export e);
	public List<Export> getExports(Export e);
	public long getTotalExports(Export e);

	public Export findExport(String id); 
	public boolean deleteExport(String ids);
	public boolean updateByKey(Export e);

}
