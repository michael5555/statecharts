package chatroom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.events.ShellListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import chatroom.chatroom.ChatRoomStatemachine;
import chatroom.chatroom.IChatRoomStatemachine.SCINetworkListener;
import chatroom.chatroom.IChatRoomStatemachine.SCINetworkOperationCallback;
import chatroom.chatroom.IChatRoomStatemachine.SCIUIOperationCallback;
import chatroom.chatroom.IChatRoomStatemachine.SCIUtilOperationCallback;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;

public class ChatRoomUI extends Composite {
	private Text text;
	private Composite composite;
	private ChatRoomStatemachine statemachine;
	ScrolledComposite scrolledComposite;
	private Label label;
	private Label label_1;
	private Label label_2;
	private Label label_3;
	private Label label_4;
	private Label label_5;
	private Label label_6;
	private Label label_7;
	private Label label_8;
	private Label label_9;
	private Label label_10;
	private Label label_11;
	private Label label_12;
	private Label label_13;
	private Label label_14;
	private Label label_15;
	private Label label_16;
	private Label label_17;
	private Label label_18;
	private Label label_19;
	private Label label_20;
	private Label label_21;
	private Label label_22;
	private Label label_23;
	private Label label_24;
	private Label label_25;
	long currTime;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public ChatRoomUI(Composite parent, int style) {
		super(parent, style);
		
		currTime = System.currentTimeMillis();
		
		setLayout(new GridLayout(1, false));
		new Label(this, SWT.NONE);
		
		scrolledComposite = new ScrolledComposite(this, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		
		GridData gd_scrolledComposite = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_scrolledComposite.widthHint = 313;
		gd_scrolledComposite.heightHint = 466;
		scrolledComposite.setLayoutData(gd_scrolledComposite);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		
		composite = new Composite(scrolledComposite, SWT.NONE);
		composite.setLayout(new RowLayout(SWT.VERTICAL));
		
		label = new Label(composite, SWT.NONE);
		
		label_1 = new Label(composite, SWT.NONE);
		
		label_2 = new Label(composite, SWT.NONE);
		
		label_3 = new Label(composite, SWT.NONE);
		
		label_4 = new Label(composite, SWT.NONE);
		
		label_5 = new Label(composite, SWT.NONE);
		
		label_6 = new Label(composite, SWT.NONE);
		
		label_7 = new Label(composite, SWT.NONE);
		
		label_8 = new Label(composite, SWT.NONE);
		
		label_9 = new Label(composite, SWT.NONE);
		
		label_10 = new Label(composite, SWT.NONE);
		
		label_11 = new Label(composite, SWT.NONE);
		
		label_12 = new Label(composite, SWT.NONE);
		
		label_13 = new Label(composite, SWT.NONE);
		
		label_14 = new Label(composite, SWT.NONE);
		
		label_15 = new Label(composite, SWT.NONE);
		
		label_16 = new Label(composite, SWT.NONE);
		
		label_17 = new Label(composite, SWT.NONE);
		
		label_18 = new Label(composite, SWT.NONE);
		
		label_19 = new Label(composite, SWT.NONE);
		
		label_20 = new Label(composite, SWT.NONE);
		
		label_21 = new Label(composite, SWT.NONE);
		
		label_22 = new Label(composite, SWT.NONE);
		
		label_23 = new Label(composite, SWT.NONE);
		
		label_24 = new Label(composite, SWT.NONE);
		
		label_25 = new Label(composite, SWT.NONE);
		
		composite.addListener(SWT.Paint, new Listener() {
			
			@Override
			public void handleEvent(Event arg0) {
				scrolledComposite.setOrigin(composite.getChildren()[composite.getChildren().length - 1].getLocation());
			}
		});
		
		scrolledComposite.setContent(composite);
		scrolledComposite.setMinSize(composite.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		
		statemachine = new ChatRoomStatemachineFixed();
		statemachine.setTimer(new TimerService());
		
		ChatRoomUI self = this;
		text = new Text(this, SWT.BORDER);
		text.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				e.doit = false;
				statemachine.getSCIUI().raiseInput(String.valueOf(e.character));
			}
		});
		
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				statemachine.getSCIUI().raiseInput(String.valueOf(e.character));
			}
		});
		
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		text.setEnabled(false);
		
		statemachine.getSCINetwork().setSCINetworkOperationCallback(new SCINetworkOperationCallback() {
			private String[] servers = {"localhost:8000", "localhost:8001"};
			
			@Override
			public String get_server(long index) {
				return servers[(int) index];
			}
			
			@Override
			public long get_nr_of_servers() {
				return servers.length;
			}
		});
		
		statemachine.getSCIUI().setSCIUIOperationCallback(new SCIUIOperationCallback() {
			
			@Override
			public void remove_last_in_buffer() {
				self.getDisplay().asyncExec(new Runnable() {
					
					@Override
					public void run() {
						self.remove_last_in_buffer();
					}
				});
			}
			
			@Override
			public void input_msg() {
				self.getDisplay().asyncExec(new Runnable() {
					
					@Override
					public void run() {
						self.input_msg();
					}
				});
			}
			
			@Override
			public void input_join() {
				self.getDisplay().asyncExec(new Runnable() {
					
					@Override
					public void run() {
						self.input_join();
					}
				});
			}
			
			@Override
			public void input_command() {
				self.getDisplay().asyncExec(new Runnable() {
					
					@Override
					public void run() {
						self.input_command();
					}
				});
			}
			
			@Override
			public String get_buffer() {
				return self.get_buffer();
			}
			
			@Override
			public void clear_input() {
				self.getDisplay().asyncExec(new Runnable() {
					
					@Override
					public void run() {
						self.clear_input();
					}
				});
			}
			
			@Override
			public void append_to_buffer(String charArg) {
				self.getDisplay().asyncExec(new Runnable() {
					
					@Override
					public void run() {
						self.append_to_buffer(charArg.charAt(0));
					}
				});				
			}
			
			@Override
			public void add_message(String msg, String type) {
				self.getDisplay().asyncExec(new Runnable() {
					
					@Override
					public void run() {
						self.add_message_by_type(msg, type);
					}
				});
			}
		});
		
		statemachine.getSCIUtil().setSCIUtilOperationCallback(new SCIUtilOperationCallback() {
			
			@Override
			public String concatenate(String one, String two) {
				return one + two;
			}

			@Override
			public long stoi(String inp) {
				return Integer.valueOf(inp);
			}

			@Override
			public String remove_last_char(String inp) {
				return inp.substring(0, inp.length() - 2);
			}

			@Override
			public boolean is_numerical(String inp) {
				try {
					Integer.parseInt(inp);
				} catch (NumberFormatException e) {
					return false;
				}
				return true;
			}

			@Override
			public boolean is_backspace(String inp) {
				return inp.charAt(0) == SWT.BS;
			}

			@Override
			public boolean is_enter(String inp) {
				return inp.charAt(0) == SWT.CR;
			}

			@Override
			public boolean is_alphanumerical(String inp) {
				return inp.matches("[A-Za-z0-9]");
			}

			@Override
			public void print(String inp) {
				System.out.println(inp);
			}
		});
		
		statemachine.getSCINetwork().getListeners().add(new SCINetworkListener() {
			private Socket socket;
			private PrintWriter out;
			private BufferedReader in;
			private String hostname;
			private Thread listenerThread;
			
			@Override
			public void onSend_messageRaised(String msg) {
				out.println("MSG " + hostname + ": " + msg);
			}
			
			@Override
			public void onPollRaised() {
				long newCurrTime = System.currentTimeMillis();
				currTime = newCurrTime;
				out.println("POLL");
			}
			
			@Override
			public void onLeaveRaised() {
				out.println("LEAVE");
			}
			
			@Override
			public void onJoinRaised(long number) {
				out.println("JOIN " + String.valueOf(number));
			}
			
			@Override
			public void onDisconnectRaised() {
				try {
					socket.close();
				} catch (IOException e) {
					// do nothing
				} finally {
					socket = null;
					out = null;
					in = null;
				}
			}
			
			@Override
			public void onConnectRaised(String value) {
				String[] splitted = value.split(":");
				hostname = splitted[0];
				int port = Integer.parseInt(splitted[1]);
				try {
					socket = new Socket(hostname, port);
					self.getDisplay().asyncExec(new Runnable() {
						
						@Override
						public void run() {
							self.getDisplay().timerExec(0, new Runnable() {
								
								@Override
								public void run() {
									try {
										out = new PrintWriter(socket.getOutputStream(), true);
										in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
										Runnable runnable = new Runnable() {
											
											@Override
											public void run() {
												while (socket != null && !socket.isClosed()) {
													try {
														String server_output = in.readLine();
														if (server_output.startsWith("ACK JOIN")) {
															Thread.sleep(100);
															statemachine.getSCINetwork().raiseJoined();
														} else if (server_output.startsWith("ACK LEAVE")) {
															Thread.sleep(100);
															statemachine.getSCINetwork().raiseLeft();
														} else if (server_output.startsWith("ALIVE")) {
															Thread.sleep(100);
															statemachine.getSCINetwork().raiseAlive();
														} else if (server_output.startsWith("MSG")) {
															Thread.sleep(100);
															statemachine.getSCINetwork().raiseReceive_message(server_output.substring(4));
														}
													} catch (IOException | InterruptedException e) {}
												}
											}
										};
										listenerThread = new Thread(runnable);
										listenerThread.start();
									} catch (IOException e) {}
									statemachine.getSCINetwork().raiseConnected();
								}
							});
						}
					});
				} catch (IOException e) {
					return;
				}
			}
		});
		
		statemachine.init();
		statemachine.enter();
		// RuntimeService.getInstance().registerStatemachine(statemachine, 20);
	}
	
	public void add_message_by_type(String message, String type) {
		Color color = SWTResourceManager.getColor(SWT.COLOR_BLACK);
		if (type == "local_message") {
			message = "Me: " + message;
			color = SWTResourceManager.getColor(SWT.COLOR_RED);
		} else if (type == "remote_message") {
			color = SWTResourceManager.getColor(SWT.COLOR_BLUE);
		}
		this.add_message(message, color);
	}
	
	public void add_message(String message, Color color) {
		Label lbl = new Label(composite, SWT.NONE);
		lbl.setText(message);
		lbl.setForeground(color);
		scrolledComposite.setContent(composite);
		scrolledComposite.setMinSize(composite.computeSize(SWT.DEFAULT, SWT.DEFAULT));
	}
	
	public void append_to_buffer(char character) {
		text.setText(text.getText() + character);
		text.setSelection(text.getTextLimit());
	}
	
	public void remove_last_in_buffer() {
		String currentText = text.getText();
		if (currentText.length() > 0) {
			text.setText(currentText.substring(0, currentText.length() - 1));
			text.setSelection(text.getTextLimit());
		}
	}
	
	public void clear_input() {
		text.setText("");
	}
	
	public void input_join() {
		text.setBackground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
	}
	
	public void input_msg() {
		text.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
	}	
	
	public void input_command() {
		text.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
	}
	
	public String get_buffer() {
		return text.getText();
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	
	public static void main(String[] args) {
		try {
			Display display = new Display();
			Shell shell = new Shell(display);
			ChatRoomUI application = new ChatRoomUI(shell, SWT.NONE);
			shell.addShellListener(new ShellListener() {
				
				@Override
				public void shellIconified(ShellEvent arg0) {}
				
				@Override
				public void shellDeiconified(ShellEvent arg0) {}
				
				@Override
				public void shellDeactivated(ShellEvent arg0) {}
				
				@Override
				public void shellClosed(ShellEvent arg0) {}
				
				@Override
				public void shellActivated(ShellEvent arg0) {
					display.asyncExec(new Runnable() {
						
						@Override
						public void run() {
							application.forceFocus();
						}
					});
				}
			});
			application.pack();
			shell.pack();
			shell.open();
			while (!application.isDisposed()) {
				if (!display.readAndDispatch()) display.sleep();
			}
			shell.dispose();
			display.dispose();
		} finally {
			System.exit(0);
		}
	}
}
