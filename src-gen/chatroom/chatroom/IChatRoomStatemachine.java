/** Generated by YAKINDU Statechart Tools code generator. */
package chatroom.chatroom;

import chatroom.IStatemachine;
import chatroom.ITimerCallback;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public interface IChatRoomStatemachine extends ITimerCallback,IStatemachine {
	public interface SCINetwork {
	
		public void raiseConnected();
		
		public void raiseDisconnected();
		
		public void raiseJoined();
		
		public void raiseLeft();
		
		public void raiseReceive_message(String value);
		
		public void raiseAlive();
		
		public boolean isRaisedConnect();
		
		public String getConnectValue();
		
		public boolean isRaisedDisconnect();
		
		public boolean isRaisedJoin();
		
		public long getJoinValue();
		
		public boolean isRaisedLeave();
		
		public boolean isRaisedPoll();
		
		public boolean isRaisedSend_message();
		
		public String getSend_messageValue();
		
	public List<SCINetworkListener> getListeners();
		public void setSCINetworkOperationCallback(SCINetworkOperationCallback operationCallback);
	
	}
	
	public interface SCINetworkListener {
	
		public void onConnectRaised(String value);
		public void onDisconnectRaised();
		public void onJoinRaised(long value);
		public void onLeaveRaised();
		public void onPollRaised();
		public void onSend_messageRaised(String value);
		}
	
	public interface SCINetworkOperationCallback {
	
		public long get_nr_of_servers();
		
		public String get_server(long index);
		
	}
	
	public SCINetwork getSCINetwork();
	
	public interface SCIUI {
	
		public void raiseInput(String value);
		
		public void setSCIUIOperationCallback(SCIUIOperationCallback operationCallback);
	
	}
	
	public interface SCIUIOperationCallback {
	
		public void add_message(String msg, String type);
		
		public void append_to_buffer(String charArg);
		
		public void remove_last_in_buffer();
		
		public void clear_input();
		
		public void input_join();
		
		public void input_msg();
		
		public void input_command();
		
		public String get_buffer();
		
	}
	
	public SCIUI getSCIUI();
	
	public interface SCIUtil {
	
		public void setSCIUtilOperationCallback(SCIUtilOperationCallback operationCallback);
	
	}
	
	public interface SCIUtilOperationCallback {
	
		public String concatenate(String one, String two);
		
		public String remove_last_char(String inp);
		
		public long stoi(String inp);
		
		public boolean is_numerical(String inp);
		
		public boolean is_backspace(String inp);
		
		public boolean is_enter(String inp);
		
		public boolean is_alphanumerical(String inp);
		
		public void print(String inp);
		
	}
	
	public SCIUtil getSCIUtil();
	
}
