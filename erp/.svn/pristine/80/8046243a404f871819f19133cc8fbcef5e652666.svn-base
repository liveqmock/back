package com.ihk.saleunit.action.pushlet;

import java.io.Serializable;

import nl.justobjects.pushlet.core.Event;
import nl.justobjects.pushlet.core.EventPullSource;

/**
 * 推送框架action(项目中暂时没有使用到)
 * @author dtc
 * 2012-9-28
 */
public class MyPushletAction extends EventPullSource implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected long getSleepTime() {
		return 4000;
	}

	@Override
	protected Event pullEvent() {
		
		Event event = Event.createDataEvent("/common/pushlet");
		
		/*int count = MyPropertyUtils.getConfirmServices().findConfirmCount(new ConfirmCond());
		if(count >= 2392){
			event.setField("pushlet", "true");
			event.setField("title", "认购总数");
			event.setField("msg", "恭喜,认购总数达到了:" + count);
		}*/
		
		event.setField("title", "title");
		
		return event;
	}

}
