/** Generated by YAKINDU Statechart Tools code generator. */
package chatroom.chatroom;

import chatroom.ITimer;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ChatRoomStatemachine implements IChatRoomStatemachine {
	protected class SCINetworkImpl implements SCINetwork {
	
		private List<SCINetworkListener> listeners = new LinkedList<SCINetworkListener>();
		
		public List<SCINetworkListener> getListeners() {
			return listeners;
		}
		private SCINetworkOperationCallback operationCallback;
		
		public synchronized void setSCINetworkOperationCallback(
				SCINetworkOperationCallback operationCallback) {
			this.operationCallback = operationCallback;
		}
		private boolean connected;
		
		
		public void raiseConnected() {
			synchronized(ChatRoomStatemachine.this) {
				connected = true;
				runCycle();
			}
		}
		
		private boolean disconnected;
		
		
		public void raiseDisconnected() {
			synchronized(ChatRoomStatemachine.this) {
				disconnected = true;
				runCycle();
			}
		}
		
		private boolean joined;
		
		
		public void raiseJoined() {
			synchronized(ChatRoomStatemachine.this) {
				joined = true;
				runCycle();
			}
		}
		
		private boolean left;
		
		
		public void raiseLeft() {
			synchronized(ChatRoomStatemachine.this) {
				left = true;
				runCycle();
			}
		}
		
		private boolean receive_message;
		
		private String receive_messageValue;
		
		
		public void raiseReceive_message(final String value) {
			synchronized(ChatRoomStatemachine.this) {
				receive_messageValue = value;
				receive_message = true;
				runCycle();
			}
		}
		protected String getReceive_messageValue() {
			synchronized(ChatRoomStatemachine.this) {
				if (! receive_message ) 
					throw new IllegalStateException("Illegal event value access. Event Receive_message is not raised!");
				return receive_messageValue;
			}
		}
		
		private boolean alive;
		
		
		public void raiseAlive() {
			synchronized(ChatRoomStatemachine.this) {
				alive = true;
				runCycle();
			}
		}
		
		private boolean connect;
		
		private String connectValue;
		
		
		public boolean isRaisedConnect() {
			synchronized(ChatRoomStatemachine.this) {
				return connect;
			}
		}
		
		protected void raiseConnect(String value) {
			synchronized(ChatRoomStatemachine.this) {
				connectValue = value;
				connect = true;
				for (SCINetworkListener listener : listeners) {
					listener.onConnectRaised(value);
				}
			}
		}
		
		public String getConnectValue() {
			synchronized(ChatRoomStatemachine.this) {
				if (! connect ) 
					throw new IllegalStateException("Illegal event value access. Event Connect is not raised!");
				return connectValue;
			}
		}
		
		private boolean disconnect;
		
		
		public boolean isRaisedDisconnect() {
			synchronized(ChatRoomStatemachine.this) {
				return disconnect;
			}
		}
		
		protected void raiseDisconnect() {
			synchronized(ChatRoomStatemachine.this) {
				disconnect = true;
				for (SCINetworkListener listener : listeners) {
					listener.onDisconnectRaised();
				}
			}
		}
		
		private boolean join;
		
		private long joinValue;
		
		
		public boolean isRaisedJoin() {
			synchronized(ChatRoomStatemachine.this) {
				return join;
			}
		}
		
		protected void raiseJoin(long value) {
			synchronized(ChatRoomStatemachine.this) {
				joinValue = value;
				join = true;
				for (SCINetworkListener listener : listeners) {
					listener.onJoinRaised(value);
				}
			}
		}
		
		public long getJoinValue() {
			synchronized(ChatRoomStatemachine.this) {
				if (! join ) 
					throw new IllegalStateException("Illegal event value access. Event Join is not raised!");
				return joinValue;
			}
		}
		
		private boolean leave;
		
		
		public boolean isRaisedLeave() {
			synchronized(ChatRoomStatemachine.this) {
				return leave;
			}
		}
		
		protected void raiseLeave() {
			synchronized(ChatRoomStatemachine.this) {
				leave = true;
				for (SCINetworkListener listener : listeners) {
					listener.onLeaveRaised();
				}
			}
		}
		
		private boolean poll;
		
		
		public boolean isRaisedPoll() {
			synchronized(ChatRoomStatemachine.this) {
				return poll;
			}
		}
		
		protected void raisePoll() {
			synchronized(ChatRoomStatemachine.this) {
				poll = true;
				for (SCINetworkListener listener : listeners) {
					listener.onPollRaised();
				}
			}
		}
		
		private boolean send_message;
		
		private String send_messageValue;
		
		
		public boolean isRaisedSend_message() {
			synchronized(ChatRoomStatemachine.this) {
				return send_message;
			}
		}
		
		protected void raiseSend_message(String value) {
			synchronized(ChatRoomStatemachine.this) {
				send_messageValue = value;
				send_message = true;
				for (SCINetworkListener listener : listeners) {
					listener.onSend_messageRaised(value);
				}
			}
		}
		
		public String getSend_messageValue() {
			synchronized(ChatRoomStatemachine.this) {
				if (! send_message ) 
					throw new IllegalStateException("Illegal event value access. Event Send_message is not raised!");
				return send_messageValue;
			}
		}
		
		protected void clearEvents() {
			connected = false;
			disconnected = false;
			joined = false;
			left = false;
			receive_message = false;
			alive = false;
		}
		protected void clearOutEvents() {
		
		connect = false;
		disconnect = false;
		join = false;
		leave = false;
		poll = false;
		send_message = false;
		}
		
	}
	
	
	protected class SCIUIImpl implements SCIUI {
	
		private SCIUIOperationCallback operationCallback;
		
		public synchronized void setSCIUIOperationCallback(
				SCIUIOperationCallback operationCallback) {
			this.operationCallback = operationCallback;
		}
		private boolean input;
		
		private String inputValue;
		
		
		public void raiseInput(final String value) {
			synchronized(ChatRoomStatemachine.this) {
				inputValue = value;
				input = true;
				runCycle();
			}
		}
		protected String getInputValue() {
			synchronized(ChatRoomStatemachine.this) {
				if (! input ) 
					throw new IllegalStateException("Illegal event value access. Event Input is not raised!");
				return inputValue;
			}
		}
		
		protected void clearEvents() {
			input = false;
		}
	}
	
	
	protected class SCIUtilImpl implements SCIUtil {
	
		private SCIUtilOperationCallback operationCallback;
		
		public synchronized void setSCIUtilOperationCallback(
				SCIUtilOperationCallback operationCallback) {
			this.operationCallback = operationCallback;
		}
	}
	
	
	protected SCINetworkImpl sCINetwork;
	
	protected SCIUIImpl sCIUI;
	
	protected SCIUtilImpl sCIUtil;
	
	private boolean initialized = false;
	
	public enum State {
		main_region_Disconnected,
		main_region_Disconnected_disconnected_region_connecting,
		main_region_Connected,
		main_region_Connected_connection_lifetime_region_ConnectionFlow,
		main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region_isconnected,
		main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region_joined,
		main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region_leaving,
		main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region_left,
		main_region_Connected_polling_region_Polling,
		main_region_Connected_polling_region_Polling_r1_sendpoll,
		main_region_Connected_polling_region_Polling_r1_serveralive,
		$NullState$
	};
	
	private final State[] stateVector = new State[2];
	
	private int nextStateIndex;
	
	private ITimer timer;
	
	private final boolean[] timeEvents = new boolean[3];
	
	private long currentserverindex;
	
	protected long getCurrentserverindex() {
		synchronized(ChatRoomStatemachine.this) {
			return currentserverindex;
		}
	}
	
	protected void setCurrentserverindex(long value) {
		synchronized(ChatRoomStatemachine.this) {
			this.currentserverindex = value;
		}
	}
	
	
	public ChatRoomStatemachine() {
		sCINetwork = new SCINetworkImpl();
		sCIUI = new SCIUIImpl();
		sCIUtil = new SCIUtilImpl();
	}
	
	public synchronized void init() {
		this.initialized = true;
		if (timer == null) {
			throw new IllegalStateException("timer not set.");
		}
		if (this.sCINetwork.operationCallback == null) {
			throw new IllegalStateException("Operation callback for interface sCINetwork must be set.");
		}
		
		if (this.sCIUI.operationCallback == null) {
			throw new IllegalStateException("Operation callback for interface sCIUI must be set.");
		}
		
		if (this.sCIUtil.operationCallback == null) {
			throw new IllegalStateException("Operation callback for interface sCIUtil must be set.");
		}
		
		for (int i = 0; i < 2; i++) {
			stateVector[i] = State.$NullState$;
		}
		clearEvents();
		clearOutEvents();
		setCurrentserverindex(0);
	}
	
	public synchronized void enter() {
		if (!initialized) {
			throw new IllegalStateException(
				"The state machine needs to be initialized first by calling the init() function."
			);
		}
		if (timer == null) {
			throw new IllegalStateException("timer not set.");
		}
		enterSequence_main_region_default();
	}
	
	public synchronized void runCycle() {
		if (!initialized)
			throw new IllegalStateException(
					"The state machine needs to be initialized first by calling the init() function.");
		clearOutEvents();
		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {
			switch (stateVector[nextStateIndex]) {
			case main_region_Disconnected_disconnected_region_connecting:
				main_region_Disconnected_disconnected_region_connecting_react(true);
				break;
			case main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region_isconnected:
				main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region_isconnected_react(true);
				break;
			case main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region_joined:
				main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region_joined_react(true);
				break;
			case main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region_leaving:
				main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region_leaving_react(true);
				break;
			case main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region_left:
				main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region_left_react(true);
				break;
			case main_region_Connected_polling_region_Polling_r1_sendpoll:
				main_region_Connected_polling_region_Polling_r1_sendpoll_react(true);
				break;
			case main_region_Connected_polling_region_Polling_r1_serveralive:
				main_region_Connected_polling_region_Polling_r1_serveralive_react(true);
				break;
			default:
				// $NullState$
			}
		}
		clearEvents();
	}
	public synchronized void exit() {
		exitSequence_main_region();
	}
	
	/**
	 * @see IStatemachine#isActive()
	 */
	public synchronized boolean isActive() {
		return stateVector[0] != State.$NullState$||stateVector[1] != State.$NullState$;
	}
	
	/** 
	* Always returns 'false' since this state machine can never become final.
	*
	* @see IStatemachine#isFinal()
	*/
	public synchronized boolean isFinal() {
		return false;
	}
	/**
	* This method resets the incoming events (time events included).
	*/
	protected void clearEvents() {
		sCINetwork.clearEvents();
		sCIUI.clearEvents();
		for (int i=0; i<timeEvents.length; i++) {
			timeEvents[i] = false;
		}
	}
	
	/**
	* This method resets the outgoing events.
	*/
	protected void clearOutEvents() {
		sCINetwork.clearOutEvents();
	}
	
	/**
	* Returns true if the given state is currently active otherwise false.
	*/
	public synchronized boolean isStateActive(State state) {
	
		switch (state) {
		case main_region_Disconnected:
			return stateVector[0].ordinal() >= State.
					main_region_Disconnected.ordinal()&& stateVector[0].ordinal() <= State.main_region_Disconnected_disconnected_region_connecting.ordinal();
		case main_region_Disconnected_disconnected_region_connecting:
			return stateVector[0] == State.main_region_Disconnected_disconnected_region_connecting;
		case main_region_Connected:
			return stateVector[0].ordinal() >= State.
					main_region_Connected.ordinal()&& stateVector[0].ordinal() <= State.main_region_Connected_polling_region_Polling_r1_serveralive.ordinal();
		case main_region_Connected_connection_lifetime_region_ConnectionFlow:
			return stateVector[0].ordinal() >= State.
					main_region_Connected_connection_lifetime_region_ConnectionFlow.ordinal()&& stateVector[0].ordinal() <= State.main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region_left.ordinal();
		case main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region_isconnected:
			return stateVector[0] == State.main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region_isconnected;
		case main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region_joined:
			return stateVector[0] == State.main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region_joined;
		case main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region_leaving:
			return stateVector[0] == State.main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region_leaving;
		case main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region_left:
			return stateVector[0] == State.main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region_left;
		case main_region_Connected_polling_region_Polling:
			return stateVector[1].ordinal() >= State.
					main_region_Connected_polling_region_Polling.ordinal()&& stateVector[1].ordinal() <= State.main_region_Connected_polling_region_Polling_r1_serveralive.ordinal();
		case main_region_Connected_polling_region_Polling_r1_sendpoll:
			return stateVector[1] == State.main_region_Connected_polling_region_Polling_r1_sendpoll;
		case main_region_Connected_polling_region_Polling_r1_serveralive:
			return stateVector[1] == State.main_region_Connected_polling_region_Polling_r1_serveralive;
		default:
			return false;
		}
	}
	
	/**
	* Set the {@link ITimer} for the state machine. It must be set
	* externally on a timed state machine before a run cycle can be correctly
	* executed.
	* 
	* @param timer
	*/
	public synchronized void setTimer(ITimer timer) {
		this.timer = timer;
	}
	
	/**
	* Returns the currently used timer.
	* 
	* @return {@link ITimer}
	*/
	public ITimer getTimer() {
		return timer;
	}
	
	public synchronized void timeElapsed(int eventID) {
		timeEvents[eventID] = true;
		runCycle();
	}
	
	public SCINetwork getSCINetwork() {
		return sCINetwork;
	}
	
	public SCIUI getSCIUI() {
		return sCIUI;
	}
	
	public SCIUtil getSCIUtil() {
		return sCIUtil;
	}
	
	/* Entry action for state 'connecting'. */
	private void entryAction_main_region_Disconnected_disconnected_region_connecting() {
		timer.setTimer(this, 0, (10 * 1000), false);
		
		sCIUI.operationCallback.add_message(sCIUtil.operationCallback.concatenate("attempting to connect to ", sCINetwork.operationCallback.get_server(getCurrentserverindex())), "info");
		
		sCINetwork.raiseConnect(sCINetwork.operationCallback.get_server(getCurrentserverindex()));
	}
	
	/* Entry action for state 'isconnected'. */
	private void entryAction_main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region_isconnected() {
		sCIUI.operationCallback.add_message("connected to server", "info");
		
		sCINetwork.raiseJoin(1);
	}
	
	/* Entry action for state 'joined'. */
	private void entryAction_main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region_joined() {
		sCIUI.operationCallback.add_message("joined room 1", "info");
	}
	
	/* Entry action for state 'leaving'. */
	private void entryAction_main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region_leaving() {
		sCIUI.operationCallback.add_message("leaving room 1", "info");
		
		sCINetwork.raiseLeave();
	}
	
	/* Entry action for state 'left'. */
	private void entryAction_main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region_left() {
		sCIUI.operationCallback.add_message("left room 1", "info");
	}
	
	/* Entry action for state 'sendpoll'. */
	private void entryAction_main_region_Connected_polling_region_Polling_r1_sendpoll() {
		timer.setTimer(this, 1, (20 * 1000), false);
		
		sCIUtil.operationCallback.print("polling connected server");
		
		sCINetwork.raisePoll();
	}
	
	/* Entry action for state 'serveralive'. */
	private void entryAction_main_region_Connected_polling_region_Polling_r1_serveralive() {
		timer.setTimer(this, 2, (10 * 1000), false);
		
		sCIUtil.operationCallback.print("connected server is still alive.");
	}
	
	/* Exit action for state 'connecting'. */
	private void exitAction_main_region_Disconnected_disconnected_region_connecting() {
		timer.unsetTimer(this, 0);
	}
	
	/* Exit action for state 'sendpoll'. */
	private void exitAction_main_region_Connected_polling_region_Polling_r1_sendpoll() {
		timer.unsetTimer(this, 1);
	}
	
	/* Exit action for state 'serveralive'. */
	private void exitAction_main_region_Connected_polling_region_Polling_r1_serveralive() {
		timer.unsetTimer(this, 2);
	}
	
	/* 'default' enter sequence for state Disconnected */
	private void enterSequence_main_region_Disconnected_default() {
		enterSequence_main_region_Disconnected_disconnected_region_default();
	}
	
	/* 'default' enter sequence for state connecting */
	private void enterSequence_main_region_Disconnected_disconnected_region_connecting_default() {
		entryAction_main_region_Disconnected_disconnected_region_connecting();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Disconnected_disconnected_region_connecting;
	}
	
	/* 'default' enter sequence for state Connected */
	private void enterSequence_main_region_Connected_default() {
		enterSequence_main_region_Connected_connection_lifetime_region_default();
		enterSequence_main_region_Connected_polling_region_default();
	}
	
	/* 'default' enter sequence for state ConnectionFlow */
	private void enterSequence_main_region_Connected_connection_lifetime_region_ConnectionFlow_default() {
		enterSequence_main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region_default();
	}
	
	/* 'default' enter sequence for state isconnected */
	private void enterSequence_main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region_isconnected_default() {
		entryAction_main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region_isconnected();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region_isconnected;
	}
	
	/* 'default' enter sequence for state joined */
	private void enterSequence_main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region_joined_default() {
		entryAction_main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region_joined();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region_joined;
	}
	
	/* 'default' enter sequence for state leaving */
	private void enterSequence_main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region_leaving_default() {
		entryAction_main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region_leaving();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region_leaving;
	}
	
	/* 'default' enter sequence for state left */
	private void enterSequence_main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region_left_default() {
		entryAction_main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region_left();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region_left;
	}
	
	/* 'default' enter sequence for state Polling */
	private void enterSequence_main_region_Connected_polling_region_Polling_default() {
		enterSequence_main_region_Connected_polling_region_Polling_r1_default();
	}
	
	/* 'default' enter sequence for state sendpoll */
	private void enterSequence_main_region_Connected_polling_region_Polling_r1_sendpoll_default() {
		entryAction_main_region_Connected_polling_region_Polling_r1_sendpoll();
		nextStateIndex = 1;
		stateVector[1] = State.main_region_Connected_polling_region_Polling_r1_sendpoll;
	}
	
	/* 'default' enter sequence for state serveralive */
	private void enterSequence_main_region_Connected_polling_region_Polling_r1_serveralive_default() {
		entryAction_main_region_Connected_polling_region_Polling_r1_serveralive();
		nextStateIndex = 1;
		stateVector[1] = State.main_region_Connected_polling_region_Polling_r1_serveralive;
	}
	
	/* 'default' enter sequence for region main region */
	private void enterSequence_main_region_default() {
		react_main_region__entry_Default();
	}
	
	/* 'default' enter sequence for region disconnected region */
	private void enterSequence_main_region_Disconnected_disconnected_region_default() {
		react_main_region_Disconnected_disconnected_region__entry_Default();
	}
	
	/* 'default' enter sequence for region connection lifetime region */
	private void enterSequence_main_region_Connected_connection_lifetime_region_default() {
		react_main_region_Connected_connection_lifetime_region__entry_Default();
	}
	
	/* 'default' enter sequence for region connectionflow region */
	private void enterSequence_main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region_default() {
		react_main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region__entry_Default();
	}
	
	/* 'default' enter sequence for region polling region */
	private void enterSequence_main_region_Connected_polling_region_default() {
		react_main_region_Connected_polling_region__entry_Default();
	}
	
	/* 'default' enter sequence for region r1 */
	private void enterSequence_main_region_Connected_polling_region_Polling_r1_default() {
		react_main_region_Connected_polling_region_Polling_r1__entry_Default();
	}
	
	/* Default exit sequence for state Disconnected */
	private void exitSequence_main_region_Disconnected() {
		exitSequence_main_region_Disconnected_disconnected_region();
	}
	
	/* Default exit sequence for state connecting */
	private void exitSequence_main_region_Disconnected_disconnected_region_connecting() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_Disconnected_disconnected_region_connecting();
	}
	
	/* Default exit sequence for state Connected */
	private void exitSequence_main_region_Connected() {
		exitSequence_main_region_Connected_connection_lifetime_region();
		exitSequence_main_region_Connected_polling_region();
	}
	
	/* Default exit sequence for state isconnected */
	private void exitSequence_main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region_isconnected() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state joined */
	private void exitSequence_main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region_joined() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state leaving */
	private void exitSequence_main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region_leaving() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state left */
	private void exitSequence_main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region_left() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state sendpoll */
	private void exitSequence_main_region_Connected_polling_region_Polling_r1_sendpoll() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
		
		exitAction_main_region_Connected_polling_region_Polling_r1_sendpoll();
	}
	
	/* Default exit sequence for state serveralive */
	private void exitSequence_main_region_Connected_polling_region_Polling_r1_serveralive() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
		
		exitAction_main_region_Connected_polling_region_Polling_r1_serveralive();
	}
	
	/* Default exit sequence for region main region */
	private void exitSequence_main_region() {
		switch (stateVector[0]) {
		case main_region_Disconnected_disconnected_region_connecting:
			exitSequence_main_region_Disconnected_disconnected_region_connecting();
			break;
		case main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region_isconnected:
			exitSequence_main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region_isconnected();
			break;
		case main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region_joined:
			exitSequence_main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region_joined();
			break;
		case main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region_leaving:
			exitSequence_main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region_leaving();
			break;
		case main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region_left:
			exitSequence_main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region_left();
			break;
		default:
			break;
		}
		
		switch (stateVector[1]) {
		case main_region_Connected_polling_region_Polling_r1_sendpoll:
			exitSequence_main_region_Connected_polling_region_Polling_r1_sendpoll();
			break;
		case main_region_Connected_polling_region_Polling_r1_serveralive:
			exitSequence_main_region_Connected_polling_region_Polling_r1_serveralive();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region disconnected region */
	private void exitSequence_main_region_Disconnected_disconnected_region() {
		switch (stateVector[0]) {
		case main_region_Disconnected_disconnected_region_connecting:
			exitSequence_main_region_Disconnected_disconnected_region_connecting();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region connection lifetime region */
	private void exitSequence_main_region_Connected_connection_lifetime_region() {
		switch (stateVector[0]) {
		case main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region_isconnected:
			exitSequence_main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region_isconnected();
			break;
		case main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region_joined:
			exitSequence_main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region_joined();
			break;
		case main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region_leaving:
			exitSequence_main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region_leaving();
			break;
		case main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region_left:
			exitSequence_main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region_left();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region connectionflow region */
	private void exitSequence_main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region() {
		switch (stateVector[0]) {
		case main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region_isconnected:
			exitSequence_main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region_isconnected();
			break;
		case main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region_joined:
			exitSequence_main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region_joined();
			break;
		case main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region_leaving:
			exitSequence_main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region_leaving();
			break;
		case main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region_left:
			exitSequence_main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region_left();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region polling region */
	private void exitSequence_main_region_Connected_polling_region() {
		switch (stateVector[1]) {
		case main_region_Connected_polling_region_Polling_r1_sendpoll:
			exitSequence_main_region_Connected_polling_region_Polling_r1_sendpoll();
			break;
		case main_region_Connected_polling_region_Polling_r1_serveralive:
			exitSequence_main_region_Connected_polling_region_Polling_r1_serveralive();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region r1 */
	private void exitSequence_main_region_Connected_polling_region_Polling_r1() {
		switch (stateVector[1]) {
		case main_region_Connected_polling_region_Polling_r1_sendpoll:
			exitSequence_main_region_Connected_polling_region_Polling_r1_sendpoll();
			break;
		case main_region_Connected_polling_region_Polling_r1_serveralive:
			exitSequence_main_region_Connected_polling_region_Polling_r1_serveralive();
			break;
		default:
			break;
		}
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region__entry_Default() {
		enterSequence_main_region_Disconnected_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region_Disconnected_disconnected_region__entry_Default() {
		enterSequence_main_region_Disconnected_disconnected_region_connecting_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region__entry_Default() {
		enterSequence_main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region_isconnected_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region_Connected_connection_lifetime_region__entry_Default() {
		enterSequence_main_region_Connected_connection_lifetime_region_ConnectionFlow_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region_Connected_polling_region_Polling_r1__entry_Default() {
		enterSequence_main_region_Connected_polling_region_Polling_r1_sendpoll_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region_Connected_polling_region__entry_Default() {
		enterSequence_main_region_Connected_polling_region_Polling_default();
	}
	
	private boolean react() {
		return false;
	}
	
	private boolean main_region_Disconnected_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			if (react()==false) {
				did_transition = false;
			}
		}
		return did_transition;
	}
	
	private boolean main_region_Disconnected_disconnected_region_connecting_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			if (main_region_Disconnected_react(try_transition)==false) {
				if (sCINetwork.connected) {
					exitSequence_main_region_Disconnected();
					enterSequence_main_region_Connected_default();
				} else {
					if (timeEvents[0]) {
						exitSequence_main_region_Disconnected_disconnected_region_connecting();
						setCurrentserverindex(currentserverindex<(sCINetwork.operationCallback.get_nr_of_servers() - 1) ? (currentserverindex + 1) : 0);
						
						enterSequence_main_region_Disconnected_disconnected_region_connecting_default();
					} else {
						did_transition = false;
					}
				}
			}
		}
		return did_transition;
	}
	
	private boolean main_region_Connected_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			if (react()==false) {
				did_transition = false;
			}
		}
		return did_transition;
	}
	
	private boolean main_region_Connected_connection_lifetime_region_ConnectionFlow_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			if (main_region_Connected_react(try_transition)==false) {
				did_transition = false;
			}
		}
		return did_transition;
	}
	
	private boolean main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region_isconnected_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			if (main_region_Connected_connection_lifetime_region_ConnectionFlow_react(try_transition)==false) {
				if (sCINetwork.joined) {
					exitSequence_main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region_isconnected();
					enterSequence_main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region_joined_default();
				} else {
					did_transition = false;
				}
			}
		}
		return did_transition;
	}
	
	private boolean main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region_joined_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			if (main_region_Connected_connection_lifetime_region_ConnectionFlow_react(try_transition)==false) {
				if (((sCIUI.input) && ((sCIUI.getInputValue()== null?"k" ==null :sCIUI.getInputValue().equals("k"))))) {
					exitSequence_main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region_joined();
					enterSequence_main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region_leaving_default();
				} else {
					did_transition = false;
				}
			}
		}
		return did_transition;
	}
	
	private boolean main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region_leaving_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			if (main_region_Connected_connection_lifetime_region_ConnectionFlow_react(try_transition)==false) {
				if (sCINetwork.left) {
					exitSequence_main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region_leaving();
					enterSequence_main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region_left_default();
				} else {
					did_transition = false;
				}
			}
		}
		return did_transition;
	}
	
	private boolean main_region_Connected_connection_lifetime_region_ConnectionFlow_connectionflow_region_left_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			if (main_region_Connected_connection_lifetime_region_ConnectionFlow_react(try_transition)==false) {
				did_transition = false;
			}
		}
		return did_transition;
	}
	
	private boolean main_region_Connected_polling_region_Polling_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			did_transition = false;
		}
		return did_transition;
	}
	
	private boolean main_region_Connected_polling_region_Polling_r1_sendpoll_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			if (main_region_Connected_polling_region_Polling_react(try_transition)==false) {
				if (sCINetwork.alive) {
					exitSequence_main_region_Connected_polling_region_Polling_r1_sendpoll();
					enterSequence_main_region_Connected_polling_region_Polling_r1_serveralive_default();
				} else {
					if (timeEvents[1]) {
						exitSequence_main_region_Connected();
						sCIUI.operationCallback.add_message(sCIUtil.operationCallback.concatenate(sCIUtil.operationCallback.concatenate("server ", sCINetwork.operationCallback.get_server(getCurrentserverindex())), "is not responding.Disconnecting"), "info");
						
						setCurrentserverindex(currentserverindex<(sCINetwork.operationCallback.get_nr_of_servers() - 1) ? (currentserverindex + 1) : 0);
						
						enterSequence_main_region_Disconnected_default();
					} else {
						did_transition = false;
					}
				}
			}
		}
		return did_transition;
	}
	
	private boolean main_region_Connected_polling_region_Polling_r1_serveralive_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			if (main_region_Connected_polling_region_Polling_react(try_transition)==false) {
				if (timeEvents[2]) {
					exitSequence_main_region_Connected_polling_region_Polling_r1_serveralive();
					enterSequence_main_region_Connected_polling_region_Polling_r1_sendpoll_default();
				} else {
					did_transition = false;
				}
			}
		}
		return did_transition;
	}
	
}
