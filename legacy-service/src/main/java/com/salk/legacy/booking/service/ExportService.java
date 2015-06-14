package com.salk.legacy.booking.service;

import java.util.List;

import com.salk.legacy.domain.Booking;
import com.salk.legacy.domain.Export;

public interface ExportService {
	public boolean addExport(Export e);
	public List<Export> getExports();

}
