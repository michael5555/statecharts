package chatroom;

import chatroom.chatroom.ChatRoomStatemachine;

public class ChatRoomStatemachineFixed extends ChatRoomStatemachine {
	
	protected class SCINetworkImplFixed extends SCINetworkImpl {

		@Override
		public synchronized void raiseConnected() {
			synchronized(ChatRoomStatemachineFixed.this) {
				super.raiseConnected();
			}
		}

		@Override
		public synchronized void raiseAlive() {
			synchronized(ChatRoomStatemachineFixed.this) {
				super.raiseAlive();
			}
		}

		@Override
		public synchronized boolean isRaisedPoll() {
			synchronized(ChatRoomStatemachineFixed.this) {
				return super.isRaisedPoll();
			}
		}

		@Override
		public synchronized boolean isRaisedDisconnect() {
			synchronized(ChatRoomStatemachineFixed.this) {
				return super.isRaisedDisconnect();
			}
		}

		@Override
		public synchronized void setSCINetworkOperationCallback(SCINetworkOperationCallback operationCallback) {
			synchronized(ChatRoomStatemachineFixed.this) {
				super.setSCINetworkOperationCallback(operationCallback);
			}
		}

		@Override
		public synchronized void raiseDisconnected() {
			synchronized(ChatRoomStatemachineFixed.this) {
				super.raiseDisconnected();
			}
		}

		@Override
		public synchronized void raiseJoined() {
			synchronized(ChatRoomStatemachineFixed.this) {
				super.raiseJoined();
			}
		}

		@Override
		public synchronized void raiseLeft() {
			synchronized(ChatRoomStatemachineFixed.this) {
				super.raiseLeft();
			}
		}

		@Override
		public synchronized void raiseReceive_message(String value) {
			synchronized(ChatRoomStatemachineFixed.this) {
				super.raiseReceive_message(value);
			}
		}

		@Override
		protected synchronized String getReceive_messageValue() {
			synchronized(ChatRoomStatemachineFixed.this) {
				return super.getReceive_messageValue();
			}
		}

		@Override
		public synchronized boolean isRaisedConnect() {
			synchronized(ChatRoomStatemachineFixed.this) {
				return super.isRaisedConnect();
			}
		}

		@Override
		protected synchronized void raiseConnect(String value) {
			synchronized(ChatRoomStatemachineFixed.this) {
				super.raiseConnect(value);
			}
		}

		@Override
		public synchronized String getConnectValue() {
			synchronized(ChatRoomStatemachineFixed.this) {
				return super.getConnectValue();
			}
		}

		@Override
		public synchronized boolean isRaisedJoin() {
			synchronized(ChatRoomStatemachineFixed.this) {
				return super.isRaisedJoin();
			}
		}

		@Override
		protected synchronized void raiseJoin(long value) {
			synchronized(ChatRoomStatemachineFixed.this) {
				super.raiseJoin(value);
			}
		}

		@Override
		public synchronized long getJoinValue() {
			synchronized(ChatRoomStatemachineFixed.this) {
				return super.getJoinValue();
			}
		}

		@Override
		public synchronized boolean isRaisedLeave() {
			synchronized(ChatRoomStatemachineFixed.this) {
				return super.isRaisedLeave();
			}
		}

		@Override
		public synchronized boolean isRaisedSend_message() {
			synchronized(ChatRoomStatemachineFixed.this) {
				return super.isRaisedSend_message();
			}
		}

		@Override
		protected synchronized void raiseSend_message(String value) {
			synchronized(ChatRoomStatemachineFixed.this) {
				super.raiseSend_message(value);
			}
		}

		@Override
		public synchronized String getSend_messageValue() {
			synchronized(ChatRoomStatemachineFixed.this) {
				return super.getSend_messageValue();
			}
		}
		
	}
	
	protected class SCIUIImplFixed extends SCIUIImpl {

		@Override
		public synchronized void setSCIUIOperationCallback(SCIUIOperationCallback operationCallback) {
			synchronized(ChatRoomStatemachineFixed.this) {
				super.setSCIUIOperationCallback(operationCallback);
			}
		}

		@Override
		public synchronized void raiseInput(String value) {
			synchronized(ChatRoomStatemachineFixed.this) {
				super.raiseInput(value);
			}
		}

		@Override
		protected synchronized String getInputValue() {
			synchronized(ChatRoomStatemachineFixed.this) {
				return super.getInputValue();
			}
		}
		
	}
	
	protected class SCIUtilImplFixed extends SCIUtilImpl {
		@Override
		public synchronized void setSCIUtilOperationCallback(SCIUtilOperationCallback operationCallback) {
			synchronized(ChatRoomStatemachineFixed.this) {
				super.setSCIUtilOperationCallback(operationCallback);
			}
		}
	}

	public ChatRoomStatemachineFixed() {
		super();
		sCINetwork = new SCINetworkImplFixed();
		sCIUI = new SCIUIImplFixed();
	}

}
