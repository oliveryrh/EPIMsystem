package com.epim.service;

import com.epim.entity.Leave;

public interface LeaveService extends BaseService<Leave> {
    public Leave find(String id);
}
