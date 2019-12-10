package Tim;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
class TelcomUser {
	private String phoneNumber;
	private String callTo;
	private ArrayList communicationRecords;
	private LinkedHashMap singLeRecord;
	public TelcomUser(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		this.communicationRecords = new ArrayList();
	}
	void generateCommunicateRecord() {
		//随机生成通话记录数目
		int recordNum = new Random().nextInt(10);
		for(int i = 0; i <= recordNum; i++) {
			//随机生成第i条通话记录
			//开始时间，当前时间之前的某个随机时间
			
			// 用System.currentTimeMillis()精确到毫秒
			long timeStart = System.currentTimeMillis() - new Random().nextInt(36000000);
			//结束时间开始后的十分钟内随机的一个时间，至少一分钟
			long timeEnd = timeStart + 60000 + new Random().nextInt(600000);
			
			//用Calendar获取当前时间
			Calendar cal = Calendar.getInstance();
			//随机减去若干小时（10小时以内）
			cal.add(Calendar.HOUR, - new Random().nextInt(10));
			//获得对应毫秒
			this.singLeRecord = new LinkedHashMap();
			this.singLeRecord.put("主叫",this.phoneNumber);
			this.singLeRecord.put("开始时间",new Date(timeStart));
			this.singLeRecord.put("结束时间",new Date(timeEnd));
			this.singLeRecord.put("被叫号码", this.getCallToPhoneNumber());
			this.singLeRecord.put("计费",this.accountFee(timeStart, timeEnd));
			this.communicationRecords.add(this.singLeRecord);
			
		}
	}
	
	//随机生成被叫号码（后四位随机）并返回
	private String getCallToPhoneNumber() {
		return "1380372" + String.valueOf(new Random().nextInt(10))
			 + String.valueOf(new Random().nextInt(10))
			 + String.valueOf(new Random().nextInt(10))
			 + String.valueOf(new Random().nextInt(10));
	}
	
	//模拟计费办法，以字符串的形式返回保留4位小数的计费结果
	private String accountFee(long timeStart, long timeEnd) {
		//每分钟收费*元
		double feePerMinute = 0.2;
		//通话分钟数按四舍五入计算
		int minutes = Math.round((timeEnd - timeStart)/60000);
		double feeTotal = feePerMinute * minutes;
		return String.format("%.4f", feeTotal);
	}
	
	//打印通话记录
	void printDetails() {
		//获取全部通话记录
		//String allRecords = this.communicationRecords.toString();
		//分割通话记录
		//String [] recordArray = allRecords.split(";");
		//循环分割记录内的每一项并输出
		Iterator itRecords = this.communicationRecords.iterator(); 
		while(itRecords.hasNext()) {
			System.out.println("---------通话记录分割线---------");
			this.singLeRecord=((LinkedHashMap)itRecords.next());
			Set entrySet=this.singLeRecord.entrySet();
			Iterator itEntry=entrySet.iterator();
			while(itEntry.hasNext()){
				Map.Entry entry=(Map.Entry)itEntry.next();
				Object key=entry.getKey();
				Object value=entry.getValue();
				System.out.println(key+":"+value);
			}
			
		}
	}
}

