package resources;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import pojo.Meta;
import pojo.RWFPayout;

public class TestDataBuild {
	
	
	public RWFPayout rwfPayoutPayload(String narration, int amount, String senderIdNumber)
	{
		
		Random random = new Random();
		
		RWFPayout p = new RWFPayout();
		p.setAccount_number("1234567890");
		p.setAccount_bank("30");
		p.setAmount(amount);
		p.setNarration(narration);
		p.setReference("testRef "+random.nextInt(900));
		p.setCurrency("RWF");
		p.setBeneficiary_name("Jane Doe");
		p.setDebit_currency("NGN");
		
		// Create and set the meta data
        Meta meta = new Meta();
       
        meta.setBeneficiaryCountry("RW");
        meta.setAccountNumber("1234567890");
        meta.setFirstName("Jane");
        meta.setLastName("Doe");
        meta.setAddress("Kigali-Gatuna Rd, Kigali, Rwanda");
        meta.setBankName("ACCESS RWANDA");
        meta.setMobileNumber("25012345678");
        meta.setRoutingNumber("30");
        meta.setSender("Godsfavour Nwoko");
        meta.setSenderCountry("NG");
        meta.setBeneficiaryName("Jane Doe");
        meta.setSenderIdNumber(senderIdNumber);
        meta.setSenderIdType("01");
        meta.setSenderIdExpiry("2032-02-06");
        meta.setSenderCity("Lagos");
        meta.setBeneficiaryIdNumber("123456y5434");
        meta.setBeneficiaryAddress("Kigali-Gatuna Rd, Kigali, Rwanda");
        meta.setBeneficiaryMobileNumber("25012345678");
        meta.setSenderDateOfBirth("2006-02-22");
        meta.setBeneficiaryIdType("01"); 
        meta.setBeneficiaryIdExpiry("2029-02-16");
        meta.setBeneficiaryDob("2007-12-31");
        meta.setSenderGender("m");
        meta.setDebitCurrencyAmount("12.39");
       
        // Add the meta object to a list
        List<Meta> metaList = new ArrayList<>();
        metaList.add(meta);

        // Set the meta list to the main object
        p.setMeta(metaList);
        
        return p;
		
	}

}
