package date0712;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ���ƶ�ҵ���������
 * 
 * @author CSH
 * @date 2018��7��11������7:02:53
 */
public class Mobile {

	public static void main(String[] args) throws IOException {

		List<ConsumInfo> list=new ArrayList<ConsumInfo>();
		ConsumInfo consumInfo1=new ConsumInfo("15797713473", "ͨ��", 45);
		ConsumInfo consumInfo2=new ConsumInfo("15797713473", "����", 6);
		ConsumInfo consumInfo3=new ConsumInfo("15797713473", "����", 12);
		list.add(consumInfo1);
		list.add(consumInfo2);
		list.add(consumInfo3);
		Map<String, List<ConsumInfo>> consumInfos=new HashMap<String, List<ConsumInfo>>();
		consumInfos.put("15797713473", list);
		CardUtil.setConsumInfos(consumInfos);
		
		
		Map<String, MobileCard> cards=new HashMap<String, MobileCard>();
		MobileCard mobileCard1=new MobileCard("15797713473", "��ʤ��", "123456", new SuperPackage());
		MobileCard mobileCard2=new MobileCard("15797712288", "����", "123456", new SuperPackage());
		MobileCard mobileCard3=new MobileCard("15797711199", "����", "123456", new SuperPackage());
		cards.put("15797713473", mobileCard1);
		cards.put("15797712288", mobileCard2);
		cards.put("15797711199", mobileCard3);
		CardUtil.setCards(cards);
		
		
		new Service().startMobile();
	}

}
