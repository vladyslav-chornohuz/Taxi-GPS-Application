package com.vehicle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicle.exceptions.TaxiInformException;
import com.vehicle.model.TaxiInformation;
import com.vehicle.model.TaxiResult;
import com.vehicle.repository.TaxiDao;
import com.vehicle.repository.TaxiResulteDoa;


@Service
public class TaxiResuliImpl implements TaxiResultService{
	
	@Autowired
	private TaxiDao taxiDao;
	
	@Autowired
	private TaxiResulteDoa res;

	@Override
	public TaxiResult calTaxiResult(String vehNo,String vehDate) throws TaxiInformException {
		List<TaxiInformation> singLt=taxiDao.findByVehicleNo(vehNo);
		if(singLt.size()>0) {			
		
		TaxiResult taxiRes=new TaxiResult();
		
		taxiRes.setVehNumber(vehNo);
		int move=0;
		int idle=0;
		String inT="";
		int c=0;
		int kmDriven=0;
		
		for(TaxiInformation el:singLt) {
			String vdate=el.getVehDateTime();
			String[] vdt=vdate.split("T");
			if(vdt[0].equals(vehDate)) {
				taxiRes.setVehDate(vehDate);
				if(c==0) {
					inT=vdt[1];
					c++;
				}else {
					if(el.getVehStatus().equals("running")) {
					String nextTime=vdt[1];
					String[] inTSt=inT.split(":");
					String[] finSt=nextTime.split(":");
					int h1=Integer.parseInt(inTSt[0]);
					int h2=Integer.parseInt(finSt[0]);
					int finmin=0;
					int hd=(h2-h1)*60;
					finmin+=hd;
					int m2=Integer.parseInt(finSt[1]);
					finmin+=m2;
					int m1=Integer.parseInt(inTSt[1]);
					finmin-=m1;
					move=finmin;	
					inT=nextTime;
					
					// km driven code
					
					kmDriven+=el.getVehSpeed_kmph()*(finmin/60);
					
					}
					else {
						
						String nextTime=vdt[1];
						String[] inTSt=inT.split(":");
						String[] finSt=nextTime.split(":");
						int h1=Integer.parseInt(inTSt[0]);
						int h2=Integer.parseInt(finSt[0]);
						int finmin=0;
						int hd=(h2-h1)*60;
						finmin+=hd;
						int m2=Integer.parseInt(finSt[1]);
						finmin+=m2;
						int m1=Integer.parseInt(inTSt[1]);
						finmin-=m1;
						idle=finmin;	
						inT=nextTime;
						
					}}}}
		taxiRes.setVehMomentIn_minutes(move);
		taxiRes.setVehIdleIn_minutes(idle);
		taxiRes.setKmDriven(kmDriven);
		
		return res.save(taxiRes);	
		
	}
		else
			throw new TaxiInformException("Invalid Vehicle Number"+vehNo);
		}
	

}
