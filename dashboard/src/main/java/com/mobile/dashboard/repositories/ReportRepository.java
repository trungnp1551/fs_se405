package com.mobile.dashboard.repositories;

import com.mobile.dashboard.models.Report;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReportRepository extends MongoRepository<Report, String> {
}
