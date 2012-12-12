package cse495;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import cse495.ClipWatch.Ear;

public class EarTest {

	@Mock
	private Graphics2D mockGraphics;
	
	@Mock
	private Transferable mockTransferable;
	
	@Mock
	private JPanel mockPanel;
	
	private ClipWatch clipWatch;
	
	private Ear ear;

	private Color colorSet;


	@Before
	public void setUp() throws Exception {
		//create/init @Mock objects
		MockitoAnnotations.initMocks(this);

		clipWatch = new ClipWatch();
		//define mock behavior (stubbing)
		when(mockPanel.getGraphics()).thenReturn(mockGraphics);
		MockUtils.setPrivateField(ClipWatch.class, clipWatch, "pan", mockPanel);
		DataFlavor[] flavors = new DataFlavor[] {new DataFlavor(String.class, "test")};
		when(mockTransferable.getTransferDataFlavors()).thenReturn(flavors);
		// mock clip board = "test"
		when(mockTransferable.getTransferData(ClipWatch.TEXT)).thenReturn("test");

		//special behavior for void returning setter
		doAnswer(new Answer<Void>() {
			public Void answer(InvocationOnMock invocation) {
				Object[] args = invocation.getArguments();
				colorSet = (Color) args[0];
				return null;
			}
		}).when(mockGraphics).setColor(any(Color.class));

		//create test subject
		ear = clipWatch.new Ear();//create inner class
	}

	@After
	public void tearDown() throws Exception {
		ear = null;
		mockPanel = null;
		clipWatch = null;
		mockGraphics = null;
	}

	@Test
	public void testDragEnter() {
		DropTargetDragEvent e = mock(DropTargetDragEvent.class);
		ear.dragEnter(e);

		//check graphics color
		assertEquals(ClipWatch.DROP, colorSet);
	}

	@Test
	public void testDragExit() {
		DropTargetDragEvent e = mock(DropTargetDragEvent.class);
		ear.dragExit(e);

		//check graphics color
		assertEquals(ClipWatch.NORMAL, colorSet);
	}

	@Test
	public void testDrop() throws Exception {
		DropTargetDropEvent e = mock(DropTargetDropEvent.class);
		when(e.getTransferable()).thenReturn(mockTransferable);
		
		//perform drop
		ear.drop(e);
		
		//verify drop acceptance
		verify(e, times(1)).acceptDrop(anyInt());
		//verify drop contents
		verify(e, times(1)).dropComplete(true);
		//check graphics color
		assertEquals(ClipWatch.NORMAL, colorSet);
	}

	@Test
	public void testActionPerformed() {
		ActionEvent e = mock(ActionEvent.class);
		// set action source button
		when(e.getSource()).thenReturn(clipWatch.button.get(3));
		
		// paste test data
		clipWatch.pasteData(mockTransferable);
		
		//reset display text
		clipWatch.displayText("reset");
		
		//perform action
		ear.actionPerformed(e);
		
		//check if pasted data is displayed
		assertEquals("test", clipWatch.text.getText());
	}

}
