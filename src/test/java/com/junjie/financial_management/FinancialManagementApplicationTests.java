package com.junjie.financial_management;

import com.junjie.financial_management.service.BillService;
import com.junjie.financial_management.service.GoodsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FinancialManagementApplicationTests {

	@Autowired
	private GoodsService goodsService;

	@Autowired
	private BillService billService;

	@Test
	void test() {


	}
}
