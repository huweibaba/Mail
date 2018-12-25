package org.mail.service.impl;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import org.mail.DAO.IReceiveDAO;
import org.mail.mailServer.GetReceiveModel;
import org.mail.model.ReceiveModel;
import org.mail.service.IReceiveService;
import org.mail.vo.Receive;
import org.mail.vo.User;

public class ReceiveService implements IReceiveService {
	GetReceiveModel gr;
	IReceiveDAO receiveDAO;

	public IReceiveDAO getReceiveDAO() {
		return receiveDAO;
	}

	public void setReceiveDAO(IReceiveDAO receiveDAO) {
		this.receiveDAO = receiveDAO;
	}

	public GetReceiveModel getGr() {
		return gr;
	}

	public void setGr(GetReceiveModel gr) {
		this.gr = gr;
	}

	public List<ReceiveModel> getReceiveModelList(String host, String username, String password) throws Exception {
		// TODO Auto-generated method stub
		return gr.getReceiveModelList(host, username, password);
	}

	public List<ReceiveModel> getNoReadMessage(User user) throws Exception {
		// TODO Auto-generated method stub
		List<ReceiveModel> returnList = new ArrayList();
		List<Receive> sqlList = receiveDAO.getAllSavedMessage(user);
		Pattern p = Pattern.compile("@");
		String address = user.getAddress();
		String password = user.getPassword();
		String host = p.split(address)[1];
		String username = p.split(address)[0];
		List<ReceiveModel> mailList = gr.getReceiveModelList(host, username, password);
		for (ReceiveModel rm : mailList) {
			int i = 0;
			for (Receive re : sqlList) {
				
				if (rm.getFromAddress().equals(re.getFromAddress()) && rm.getDate().equals(re.getSendtime())) {
					if(re.getIsread()==0)
						returnList.add(rm);
					i = 1;
					break;
				}
			}
			if (i == 0) {
				Receive r = new Receive();
				r.setFromAddress(rm.getFromAddress());
				r.setToAddress(address);
				r.setSendtime(rm.getDate());
				r.setIsread(0);
				receiveDAO.saveNewMessage(r);
                returnList.add(rm);
			}
		}
		
		return returnList;
	}

	@Override
	public void changeTag(String fromAddress, String toAddress, String sendtime) {
		// TODO Auto-generated method stub
		receiveDAO.changeTag(fromAddress, toAddress, sendtime);
	}

}
