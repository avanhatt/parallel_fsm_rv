package mop;
import java.io.*;
import com.runtimeverification.rvmonitor.java.rt.RVMLogging;
import com.runtimeverification.rvmonitor.java.rt.RVMLogging.Level;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;
import java.lang.ref.*;
import com.runtimeverification.rvmonitor.java.rt.*;
import com.runtimeverification.rvmonitor.java.rt.ref.*;
import com.runtimeverification.rvmonitor.java.rt.table.*;
import com.runtimeverification.rvmonitor.java.rt.tablebase.AbstractIndexingTree;
import com.runtimeverification.rvmonitor.java.rt.tablebase.SetEventDelegator;
import com.runtimeverification.rvmonitor.java.rt.tablebase.TableAdopter.Tuple2;
import com.runtimeverification.rvmonitor.java.rt.tablebase.TableAdopter.Tuple3;
import com.runtimeverification.rvmonitor.java.rt.tablebase.IDisableHolder;
import com.runtimeverification.rvmonitor.java.rt.tablebase.IMonitor;
import com.runtimeverification.rvmonitor.java.rt.tablebase.DisableHolder;
import com.runtimeverification.rvmonitor.java.rt.tablebase.TerminatedMonitorCleaner;
import java.util.concurrent.atomic.AtomicInteger;

final class ByteArrayOutputStream_FlushBeforeRetrieveMonitor_Set extends com.runtimeverification.rvmonitor.java.rt.tablebase.AbstractMonitorSet<ByteArrayOutputStream_FlushBeforeRetrieveMonitor> {

	ByteArrayOutputStream_FlushBeforeRetrieveMonitor_Set(){
		this.size = 0;
		this.elements = new ByteArrayOutputStream_FlushBeforeRetrieveMonitor[4];
	}
	final void event_outputstreaminit(ByteArrayOutputStream b, OutputStream o) {
		int numAlive = 0 ;
		for(int i_1 = 0; i_1 < this.size; i_1++){
			ByteArrayOutputStream_FlushBeforeRetrieveMonitor monitor = this.elements[i_1];
			if(!monitor.isTerminated()){
				elements[numAlive] = monitor;
				numAlive++;

				final ByteArrayOutputStream_FlushBeforeRetrieveMonitor monitorfinalMonitor = monitor;
				monitor.Prop_1_event_outputstreaminit(b, o);
				if(monitorfinalMonitor.ByteArrayOutputStream_FlushBeforeRetrieveMonitor_Prop_1_Category_fail) {
					monitorfinalMonitor.Prop_1_handler_fail();
				}
			}
		}
		for(int i_1 = numAlive; i_1 < this.size; i_1++){
			this.elements[i_1] = null;
		}
		size = numAlive;
	}
	final void event_write(OutputStream o) {
		int numAlive = 0 ;
		for(int i_1 = 0; i_1 < this.size; i_1++){
			ByteArrayOutputStream_FlushBeforeRetrieveMonitor monitor = this.elements[i_1];
			if(!monitor.isTerminated()){
				elements[numAlive] = monitor;
				numAlive++;

				final ByteArrayOutputStream_FlushBeforeRetrieveMonitor monitorfinalMonitor = monitor;
				monitor.Prop_1_event_write(o);
				if(monitorfinalMonitor.ByteArrayOutputStream_FlushBeforeRetrieveMonitor_Prop_1_Category_fail) {
					monitorfinalMonitor.Prop_1_handler_fail();
				}
			}
		}
		for(int i_1 = numAlive; i_1 < this.size; i_1++){
			this.elements[i_1] = null;
		}
		size = numAlive;
	}
	final void event_flush(OutputStream o) {
		int numAlive = 0 ;
		for(int i_1 = 0; i_1 < this.size; i_1++){
			ByteArrayOutputStream_FlushBeforeRetrieveMonitor monitor = this.elements[i_1];
			if(!monitor.isTerminated()){
				elements[numAlive] = monitor;
				numAlive++;

				final ByteArrayOutputStream_FlushBeforeRetrieveMonitor monitorfinalMonitor = monitor;
				monitor.Prop_1_event_flush(o);
				if(monitorfinalMonitor.ByteArrayOutputStream_FlushBeforeRetrieveMonitor_Prop_1_Category_fail) {
					monitorfinalMonitor.Prop_1_handler_fail();
				}
			}
		}
		for(int i_1 = numAlive; i_1 < this.size; i_1++){
			this.elements[i_1] = null;
		}
		size = numAlive;
	}
	final void event_close(OutputStream o) {
		int numAlive = 0 ;
		for(int i_1 = 0; i_1 < this.size; i_1++){
			ByteArrayOutputStream_FlushBeforeRetrieveMonitor monitor = this.elements[i_1];
			if(!monitor.isTerminated()){
				elements[numAlive] = monitor;
				numAlive++;

				final ByteArrayOutputStream_FlushBeforeRetrieveMonitor monitorfinalMonitor = monitor;
				monitor.Prop_1_event_close(o);
				if(monitorfinalMonitor.ByteArrayOutputStream_FlushBeforeRetrieveMonitor_Prop_1_Category_fail) {
					monitorfinalMonitor.Prop_1_handler_fail();
				}
			}
		}
		for(int i_1 = numAlive; i_1 < this.size; i_1++){
			this.elements[i_1] = null;
		}
		size = numAlive;
	}
	final void event_tobytearray(ByteArrayOutputStream b) {
		int numAlive = 0 ;
		for(int i_1 = 0; i_1 < this.size; i_1++){
			ByteArrayOutputStream_FlushBeforeRetrieveMonitor monitor = this.elements[i_1];
			if(!monitor.isTerminated()){
				elements[numAlive] = monitor;
				numAlive++;

				final ByteArrayOutputStream_FlushBeforeRetrieveMonitor monitorfinalMonitor = monitor;
				monitor.Prop_1_event_tobytearray(b);
				if(monitorfinalMonitor.ByteArrayOutputStream_FlushBeforeRetrieveMonitor_Prop_1_Category_fail) {
					monitorfinalMonitor.Prop_1_handler_fail();
				}
			}
		}
		for(int i_1 = numAlive; i_1 < this.size; i_1++){
			this.elements[i_1] = null;
		}
		size = numAlive;
	}
	final void event_tostring(ByteArrayOutputStream b) {
		int numAlive = 0 ;
		for(int i_1 = 0; i_1 < this.size; i_1++){
			ByteArrayOutputStream_FlushBeforeRetrieveMonitor monitor = this.elements[i_1];
			if(!monitor.isTerminated()){
				elements[numAlive] = monitor;
				numAlive++;

				final ByteArrayOutputStream_FlushBeforeRetrieveMonitor monitorfinalMonitor = monitor;
				monitor.Prop_1_event_tostring(b);
				if(monitorfinalMonitor.ByteArrayOutputStream_FlushBeforeRetrieveMonitor_Prop_1_Category_fail) {
					monitorfinalMonitor.Prop_1_handler_fail();
				}
			}
		}
		for(int i_1 = numAlive; i_1 < this.size; i_1++){
			this.elements[i_1] = null;
		}
		size = numAlive;
	}
}
final class ListIterator_hasNextPreviousMonitor_Set extends com.runtimeverification.rvmonitor.java.rt.tablebase.AbstractMonitorSet<ListIterator_hasNextPreviousMonitor> {

	ListIterator_hasNextPreviousMonitor_Set(){
		this.size = 0;
		this.elements = new ListIterator_hasNextPreviousMonitor[4];
	}
	final void event_hasnexttrue(ListIterator i, boolean b) {
		int numAlive = 0 ;
		for(int i_1 = 0; i_1 < this.size; i_1++){
			ListIterator_hasNextPreviousMonitor monitor = this.elements[i_1];
			if(!monitor.isTerminated()){
				elements[numAlive] = monitor;
				numAlive++;

				final ListIterator_hasNextPreviousMonitor monitorfinalMonitor = monitor;
				monitor.Prop_1_event_hasnexttrue(i, b);
				if(monitorfinalMonitor.ListIterator_hasNextPreviousMonitor_Prop_1_Category_fail) {
					monitorfinalMonitor.Prop_1_handler_fail();
				}
			}
		}
		for(int i_1 = numAlive; i_1 < this.size; i_1++){
			this.elements[i_1] = null;
		}
		size = numAlive;
	}
	final void event_hasnextfalse(ListIterator i, boolean b) {
		int numAlive = 0 ;
		for(int i_1 = 0; i_1 < this.size; i_1++){
			ListIterator_hasNextPreviousMonitor monitor = this.elements[i_1];
			if(!monitor.isTerminated()){
				elements[numAlive] = monitor;
				numAlive++;

				final ListIterator_hasNextPreviousMonitor monitorfinalMonitor = monitor;
				monitor.Prop_1_event_hasnextfalse(i, b);
				if(monitorfinalMonitor.ListIterator_hasNextPreviousMonitor_Prop_1_Category_fail) {
					monitorfinalMonitor.Prop_1_handler_fail();
				}
			}
		}
		for(int i_1 = numAlive; i_1 < this.size; i_1++){
			this.elements[i_1] = null;
		}
		size = numAlive;
	}
	final void event_next(ListIterator i) {
		int numAlive = 0 ;
		for(int i_1 = 0; i_1 < this.size; i_1++){
			ListIterator_hasNextPreviousMonitor monitor = this.elements[i_1];
			if(!monitor.isTerminated()){
				elements[numAlive] = monitor;
				numAlive++;

				final ListIterator_hasNextPreviousMonitor monitorfinalMonitor = monitor;
				monitor.Prop_1_event_next(i);
				if(monitorfinalMonitor.ListIterator_hasNextPreviousMonitor_Prop_1_Category_fail) {
					monitorfinalMonitor.Prop_1_handler_fail();
				}
			}
		}
		for(int i_1 = numAlive; i_1 < this.size; i_1++){
			this.elements[i_1] = null;
		}
		size = numAlive;
	}
	final void event_hasprevioustrue(ListIterator i, boolean b) {
		int numAlive = 0 ;
		for(int i_1 = 0; i_1 < this.size; i_1++){
			ListIterator_hasNextPreviousMonitor monitor = this.elements[i_1];
			if(!monitor.isTerminated()){
				elements[numAlive] = monitor;
				numAlive++;

				final ListIterator_hasNextPreviousMonitor monitorfinalMonitor = monitor;
				monitor.Prop_1_event_hasprevioustrue(i, b);
				if(monitorfinalMonitor.ListIterator_hasNextPreviousMonitor_Prop_1_Category_fail) {
					monitorfinalMonitor.Prop_1_handler_fail();
				}
			}
		}
		for(int i_1 = numAlive; i_1 < this.size; i_1++){
			this.elements[i_1] = null;
		}
		size = numAlive;
	}
	final void event_haspreviousfalse(ListIterator i, boolean b) {
		int numAlive = 0 ;
		for(int i_1 = 0; i_1 < this.size; i_1++){
			ListIterator_hasNextPreviousMonitor monitor = this.elements[i_1];
			if(!monitor.isTerminated()){
				elements[numAlive] = monitor;
				numAlive++;

				final ListIterator_hasNextPreviousMonitor monitorfinalMonitor = monitor;
				monitor.Prop_1_event_haspreviousfalse(i, b);
				if(monitorfinalMonitor.ListIterator_hasNextPreviousMonitor_Prop_1_Category_fail) {
					monitorfinalMonitor.Prop_1_handler_fail();
				}
			}
		}
		for(int i_1 = numAlive; i_1 < this.size; i_1++){
			this.elements[i_1] = null;
		}
		size = numAlive;
	}
	final void event_previous(ListIterator i) {
		int numAlive = 0 ;
		for(int i_1 = 0; i_1 < this.size; i_1++){
			ListIterator_hasNextPreviousMonitor monitor = this.elements[i_1];
			if(!monitor.isTerminated()){
				elements[numAlive] = monitor;
				numAlive++;

				final ListIterator_hasNextPreviousMonitor monitorfinalMonitor = monitor;
				monitor.Prop_1_event_previous(i);
				if(monitorfinalMonitor.ListIterator_hasNextPreviousMonitor_Prop_1_Category_fail) {
					monitorfinalMonitor.Prop_1_handler_fail();
				}
			}
		}
		for(int i_1 = numAlive; i_1 < this.size; i_1++){
			this.elements[i_1] = null;
		}
		size = numAlive;
	}
}

class ByteArrayOutputStream_FlushBeforeRetrieveMonitor extends com.runtimeverification.rvmonitor.java.rt.tablebase.AbstractAtomicMonitor implements Cloneable, com.runtimeverification.rvmonitor.java.rt.RVMObject {
	protected Object clone() {
		try {
			ByteArrayOutputStream_FlushBeforeRetrieveMonitor ret = (ByteArrayOutputStream_FlushBeforeRetrieveMonitor) super.clone();
			ret.pairValue = new AtomicInteger(pairValue.get());
			return ret;
		}
		catch (CloneNotSupportedException e) {
			throw new InternalError(e.toString());
		}
	}

	WeakReference Ref_b = null;
	WeakReference Ref_o = null;

	static final int Prop_1_transition_outputstreaminit[] = {3, 4, 4, 4, 4};;
	static final int Prop_1_transition_write[] = {4, 3, 4, 3, 4};;
	static final int Prop_1_transition_flush[] = {4, 1, 4, 1, 4};;
	static final int Prop_1_transition_close[] = {4, 2, 4, 2, 4};;
	static final int Prop_1_transition_tobytearray[] = {4, 1, 2, 4, 4};;
	static final int Prop_1_transition_tostring[] = {4, 1, 2, 4, 4};;

	volatile boolean ByteArrayOutputStream_FlushBeforeRetrieveMonitor_Prop_1_Category_fail = false;

	private AtomicInteger pairValue;

	ByteArrayOutputStream_FlushBeforeRetrieveMonitor() {
		this.pairValue = new AtomicInteger(this.calculatePairValue(-1, 0) ) ;

	}

	@Override public final int getState() {
		return this.getState(this.pairValue.get() ) ;
	}
	@Override public final int getLastEvent() {
		return this.getLastEvent(this.pairValue.get() ) ;
	}
	private final int getState(int pairValue) {
		return (pairValue & 7) ;
	}
	private final int getLastEvent(int pairValue) {
		return (pairValue >> 3) ;
	}
	private final int calculatePairValue(int lastEvent, int state) {
		return (((lastEvent + 1) << 3) | state) ;
	}

	private final int handleEvent(int eventId, int[] table) {
		int nextstate;
		while (true) {
			int oldpairvalue = this.pairValue.get() ;
			int oldstate = this.getState(oldpairvalue) ;
			nextstate = table [ oldstate ];
			int nextpairvalue = this.calculatePairValue(eventId, nextstate) ;
			if (this.pairValue.compareAndSet(oldpairvalue, nextpairvalue) ) {
				break;
			}
		}
		return nextstate;
	}

	final boolean Prop_1_event_outputstreaminit(ByteArrayOutputStream b, OutputStream o) {
		{
			System.out.println("AVH:outputstreaminit" + System.identityHashCode(this));
		}
		if(Ref_b == null){
			Ref_b = new WeakReference(b);
		}
		if(Ref_o == null){
			Ref_o = new WeakReference(o);
		}

		int nextstate = this.handleEvent(0, Prop_1_transition_outputstreaminit) ;
		this.ByteArrayOutputStream_FlushBeforeRetrieveMonitor_Prop_1_Category_fail = nextstate == 4;

		return true;
	}

	final boolean Prop_1_event_write(OutputStream o) {
		ByteArrayOutputStream b = null;
		if(Ref_b != null){
			b = (ByteArrayOutputStream)Ref_b.get();
		}
		{
			System.out.println("AVH:write" + System.identityHashCode(this));
		}
		if(Ref_o == null){
			Ref_o = new WeakReference(o);
		}

		int nextstate = this.handleEvent(1, Prop_1_transition_write) ;
		this.ByteArrayOutputStream_FlushBeforeRetrieveMonitor_Prop_1_Category_fail = nextstate == 4;

		return true;
	}

	final boolean Prop_1_event_flush(OutputStream o) {
		ByteArrayOutputStream b = null;
		if(Ref_b != null){
			b = (ByteArrayOutputStream)Ref_b.get();
		}
		{
			System.out.println("AVH:flush" + System.identityHashCode(this));
		}
		if(Ref_o == null){
			Ref_o = new WeakReference(o);
		}

		int nextstate = this.handleEvent(2, Prop_1_transition_flush) ;
		this.ByteArrayOutputStream_FlushBeforeRetrieveMonitor_Prop_1_Category_fail = nextstate == 4;

		return true;
	}

	final boolean Prop_1_event_close(OutputStream o) {
		ByteArrayOutputStream b = null;
		if(Ref_b != null){
			b = (ByteArrayOutputStream)Ref_b.get();
		}
		{
			System.out.println("AVH:close" + System.identityHashCode(this));
		}
		if(Ref_o == null){
			Ref_o = new WeakReference(o);
		}

		int nextstate = this.handleEvent(3, Prop_1_transition_close) ;
		this.ByteArrayOutputStream_FlushBeforeRetrieveMonitor_Prop_1_Category_fail = nextstate == 4;

		return true;
	}

	final boolean Prop_1_event_tobytearray(ByteArrayOutputStream b) {
		OutputStream o = null;
		if(Ref_o != null){
			o = (OutputStream)Ref_o.get();
		}
		{
			System.out.println("AVH:tobytearray" + System.identityHashCode(this));
		}
		if(Ref_b == null){
			Ref_b = new WeakReference(b);
		}

		int nextstate = this.handleEvent(4, Prop_1_transition_tobytearray) ;
		this.ByteArrayOutputStream_FlushBeforeRetrieveMonitor_Prop_1_Category_fail = nextstate == 4;

		return true;
	}

	final boolean Prop_1_event_tostring(ByteArrayOutputStream b) {
		OutputStream o = null;
		if(Ref_o != null){
			o = (OutputStream)Ref_o.get();
		}
		{
			System.out.println("AVH:tostring" + System.identityHashCode(this));
		}
		if(Ref_b == null){
			Ref_b = new WeakReference(b);
		}

		int nextstate = this.handleEvent(5, Prop_1_transition_tostring) ;
		this.ByteArrayOutputStream_FlushBeforeRetrieveMonitor_Prop_1_Category_fail = nextstate == 4;

		return true;
	}

	final void Prop_1_handler_fail (){
		{
			RVMLogging.out.println(Level.CRITICAL, "Specification ByteArrayOutputStream_FlushBeforeRetrieve has been violated on line " + com.runtimeverification.rvmonitor.java.rt.ViolationRecorder.getLineOfCode() + ". Documentation for this property can be found at http://runtimeverification.com/monitor/annotated-java/__properties/html/mop/ByteArrayOutputStream_FlushBeforeRetrieve.html");
			RVMLogging.out.println(Level.CRITICAL, "flush() or close() should be invoked before toByteArray() or toString() to get the complete contents." + com.runtimeverification.rvmonitor.java.rt.ViolationRecorder.getLineOfCode());
		}

	}

	final void reset() {
		this.pairValue.set(this.calculatePairValue(-1, 0) ) ;

		ByteArrayOutputStream_FlushBeforeRetrieveMonitor_Prop_1_Category_fail = false;
	}

	// RVMRef_b was suppressed to reduce memory overhead
	// RVMRef_o was suppressed to reduce memory overhead

	//alive_parameters_0 = [ByteArrayOutputStream b]
	boolean alive_parameters_0 = true;
	//alive_parameters_1 = [OutputStream o]
	boolean alive_parameters_1 = true;

	@Override
	protected final void terminateInternal(int idnum) {
		int lastEvent = this.getLastEvent();

		switch(idnum){
			case 0:
			alive_parameters_0 = false;
			break;
			case 1:
			alive_parameters_1 = false;
			break;
		}
		switch(lastEvent) {
			case -1:
			return;
			case 0:
			//outputstreaminit
			//alive_b || alive_o
			if(!(alive_parameters_0 || alive_parameters_1)){
				RVM_terminated = true;
				return;
			}
			break;

			case 1:
			//write
			//alive_b || alive_o
			if(!(alive_parameters_0 || alive_parameters_1)){
				RVM_terminated = true;
				return;
			}
			break;

			case 2:
			//flush
			//alive_b || alive_o
			if(!(alive_parameters_0 || alive_parameters_1)){
				RVM_terminated = true;
				return;
			}
			break;

			case 3:
			//close
			//alive_b || alive_o
			if(!(alive_parameters_0 || alive_parameters_1)){
				RVM_terminated = true;
				return;
			}
			break;

			case 4:
			//tobytearray
			//alive_b || alive_o
			if(!(alive_parameters_0 || alive_parameters_1)){
				RVM_terminated = true;
				return;
			}
			break;

			case 5:
			//tostring
			//alive_b || alive_o
			if(!(alive_parameters_0 || alive_parameters_1)){
				RVM_terminated = true;
				return;
			}
			break;

		}
		return;
	}

	public static int getNumberOfEvents() {
		return 6;
	}

	public static int getNumberOfStates() {
		return 5;
	}

}
class ListIterator_hasNextPreviousMonitor extends com.runtimeverification.rvmonitor.java.rt.tablebase.AbstractAtomicMonitor implements Cloneable, com.runtimeverification.rvmonitor.java.rt.RVMObject {
	protected Object clone() {
		try {
			ListIterator_hasNextPreviousMonitor ret = (ListIterator_hasNextPreviousMonitor) super.clone();
			ret.pairValue = new AtomicInteger(pairValue.get());
			return ret;
		}
		catch (CloneNotSupportedException e) {
			throw new InternalError(e.toString());
		}
	}

	static final int Prop_1_transition_hasnexttrue[] = {2, 1, 2, 1, 4};;
	static final int Prop_1_transition_hasnextfalse[] = {0, 3, 0, 3, 4};;
	static final int Prop_1_transition_next[] = {4, 3, 3, 4, 4};;
	static final int Prop_1_transition_hasprevioustrue[] = {3, 1, 1, 3, 4};;
	static final int Prop_1_transition_haspreviousfalse[] = {0, 2, 2, 0, 4};;
	static final int Prop_1_transition_previous[] = {4, 2, 4, 2, 4};;

	volatile boolean ListIterator_hasNextPreviousMonitor_Prop_1_Category_fail = false;

	private AtomicInteger pairValue;

	ListIterator_hasNextPreviousMonitor() {
		this.pairValue = new AtomicInteger(this.calculatePairValue(-1, 0) ) ;

	}

	@Override public final int getState() {
		return this.getState(this.pairValue.get() ) ;
	}
	@Override public final int getLastEvent() {
		return this.getLastEvent(this.pairValue.get() ) ;
	}
	private final int getState(int pairValue) {
		return (pairValue & 7) ;
	}
	private final int getLastEvent(int pairValue) {
		return (pairValue >> 3) ;
	}
	private final int calculatePairValue(int lastEvent, int state) {
		return (((lastEvent + 1) << 3) | state) ;
	}

	private final int handleEvent(int eventId, int[] table) {
		int nextstate;
		while (true) {
			int oldpairvalue = this.pairValue.get() ;
			int oldstate = this.getState(oldpairvalue) ;
			nextstate = table [ oldstate ];
			int nextpairvalue = this.calculatePairValue(eventId, nextstate) ;
			if (this.pairValue.compareAndSet(oldpairvalue, nextpairvalue) ) {
				break;
			}
		}
		return nextstate;
	}

	final boolean Prop_1_event_hasnexttrue(ListIterator i, boolean b) {
		{
			if ( ! (b) ) {
				return false;
			}
			{
				System.out.println("AVH:hasnexttrue" + System.identityHashCode(this));
			}
		}

		int nextstate = this.handleEvent(0, Prop_1_transition_hasnexttrue) ;
		this.ListIterator_hasNextPreviousMonitor_Prop_1_Category_fail = nextstate == 4;

		return true;
	}

	final boolean Prop_1_event_hasnextfalse(ListIterator i, boolean b) {
		{
			if ( ! (!b) ) {
				return false;
			}
			{
				System.out.println("AVH:hasnextfalse" + System.identityHashCode(this));
			}
		}

		int nextstate = this.handleEvent(1, Prop_1_transition_hasnextfalse) ;
		this.ListIterator_hasNextPreviousMonitor_Prop_1_Category_fail = nextstate == 4;

		return true;
	}

	final boolean Prop_1_event_next(ListIterator i) {
		{
			System.out.println("AVH:next" + System.identityHashCode(this));
		}

		int nextstate = this.handleEvent(2, Prop_1_transition_next) ;
		this.ListIterator_hasNextPreviousMonitor_Prop_1_Category_fail = nextstate == 4;

		return true;
	}

	final boolean Prop_1_event_hasprevioustrue(ListIterator i, boolean b) {
		{
			if ( ! (b) ) {
				return false;
			}
			{
				System.out.println("AVH:hasprevioustrue" + System.identityHashCode(this));
			}
		}

		int nextstate = this.handleEvent(3, Prop_1_transition_hasprevioustrue) ;
		this.ListIterator_hasNextPreviousMonitor_Prop_1_Category_fail = nextstate == 4;

		return true;
	}

	final boolean Prop_1_event_haspreviousfalse(ListIterator i, boolean b) {
		{
			if ( ! (!b) ) {
				return false;
			}
			{
				System.out.println("AVH:haspreviousfalse" + System.identityHashCode(this));
			}
		}

		int nextstate = this.handleEvent(4, Prop_1_transition_haspreviousfalse) ;
		this.ListIterator_hasNextPreviousMonitor_Prop_1_Category_fail = nextstate == 4;

		return true;
	}

	final boolean Prop_1_event_previous(ListIterator i) {
		{
			System.out.println("AVH:previous" + System.identityHashCode(this));
		}

		int nextstate = this.handleEvent(5, Prop_1_transition_previous) ;
		this.ListIterator_hasNextPreviousMonitor_Prop_1_Category_fail = nextstate == 4;

		return true;
	}

	final void Prop_1_handler_fail (){
		{
			RVMLogging.out.println(Level.WARNING, "Specification ListIterator_hasNextPrevious has been violated on line " + com.runtimeverification.rvmonitor.java.rt.ViolationRecorder.getLineOfCode() + ". Documentation for this property can be found at http://runtimeverification.com/monitor/annotated-java/__properties/html/mop/ListIterator_hasNextPrevious.html");
			RVMLogging.out.println(Level.WARNING, "ListIterator.hasNext()/hasPrevious() was not called before calling next()/previous().");
		}

	}

	final void reset() {
		this.pairValue.set(this.calculatePairValue(-1, 0) ) ;

		ListIterator_hasNextPreviousMonitor_Prop_1_Category_fail = false;
	}

	// RVMRef_i was suppressed to reduce memory overhead

	//alive_parameters_0 = [ListIterator i]
	boolean alive_parameters_0 = true;

	@Override
	protected final void terminateInternal(int idnum) {
		int lastEvent = this.getLastEvent();

		switch(idnum){
			case 0:
			alive_parameters_0 = false;
			break;
		}
		switch(lastEvent) {
			case -1:
			return;
			case 0:
			//hasnexttrue
			//alive_i
			if(!(alive_parameters_0)){
				RVM_terminated = true;
				return;
			}
			break;

			case 1:
			//hasnextfalse
			//alive_i
			if(!(alive_parameters_0)){
				RVM_terminated = true;
				return;
			}
			break;

			case 2:
			//next
			//alive_i
			if(!(alive_parameters_0)){
				RVM_terminated = true;
				return;
			}
			break;

			case 3:
			//hasprevioustrue
			//alive_i
			if(!(alive_parameters_0)){
				RVM_terminated = true;
				return;
			}
			break;

			case 4:
			//haspreviousfalse
			//alive_i
			if(!(alive_parameters_0)){
				RVM_terminated = true;
				return;
			}
			break;

			case 5:
			//previous
			//alive_i
			if(!(alive_parameters_0)){
				RVM_terminated = true;
				return;
			}
			break;

		}
		return;
	}

	public static int getNumberOfEvents() {
		return 6;
	}

	public static int getNumberOfStates() {
		return 5;
	}

}

public final class MultiSpec_1RuntimeMonitor implements com.runtimeverification.rvmonitor.java.rt.RVMObject {
	private static com.runtimeverification.rvmonitor.java.rt.map.RVMMapManager MultiSpec_1MapManager;
	static {
		MultiSpec_1MapManager = new com.runtimeverification.rvmonitor.java.rt.map.RVMMapManager();
		MultiSpec_1MapManager.start();
	}

	// Declarations for the Lock
	static final ReentrantLock MultiSpec_1_RVMLock = new ReentrantLock();
	static final Condition MultiSpec_1_RVMLock_cond = MultiSpec_1_RVMLock.newCondition();

	private static boolean ByteArrayOutputStream_FlushBeforeRetrieve_activated = false;
	private static boolean ListIterator_hasNextPrevious_activated = false;

	// Declarations for Indexing Trees
	private static Object ByteArrayOutputStream_FlushBeforeRetrieve_b_Map_cachekey_b;
	private static Tuple2<MapOfMonitor<ByteArrayOutputStream_FlushBeforeRetrieveMonitor>, ByteArrayOutputStream_FlushBeforeRetrieveMonitor_Set> ByteArrayOutputStream_FlushBeforeRetrieve_b_Map_cachevalue;
	private static Object ByteArrayOutputStream_FlushBeforeRetrieve_b_o_Map_cachekey_b;
	private static Object ByteArrayOutputStream_FlushBeforeRetrieve_b_o_Map_cachekey_o;
	private static ByteArrayOutputStream_FlushBeforeRetrieveMonitor ByteArrayOutputStream_FlushBeforeRetrieve_b_o_Map_cachevalue;
	private static Object ByteArrayOutputStream_FlushBeforeRetrieve_o_Map_cachekey_o;
	private static ByteArrayOutputStream_FlushBeforeRetrieveMonitor_Set ByteArrayOutputStream_FlushBeforeRetrieve_o_Map_cachevalue;
	private static final MapOfSet<ByteArrayOutputStream_FlushBeforeRetrieveMonitor_Set> ByteArrayOutputStream_FlushBeforeRetrieve_o_Map = new MapOfSet<ByteArrayOutputStream_FlushBeforeRetrieveMonitor_Set>(1) ;
	private static final MapOfMapSet<MapOfMonitor<ByteArrayOutputStream_FlushBeforeRetrieveMonitor>, ByteArrayOutputStream_FlushBeforeRetrieveMonitor_Set> ByteArrayOutputStream_FlushBeforeRetrieve_b_o_Map = new MapOfMapSet<MapOfMonitor<ByteArrayOutputStream_FlushBeforeRetrieveMonitor>, ByteArrayOutputStream_FlushBeforeRetrieveMonitor_Set>(0) ;

	private static Object ListIterator_hasNextPrevious_i_Map_cachekey_i;
	private static ListIterator_hasNextPreviousMonitor ListIterator_hasNextPrevious_i_Map_cachevalue;
	private static final MapOfMonitor<ListIterator_hasNextPreviousMonitor> ListIterator_hasNextPrevious_i_Map = new MapOfMonitor<ListIterator_hasNextPreviousMonitor>(0) ;

	public static int cleanUp() {
		int collected = 0;
		// indexing trees
		collected += ByteArrayOutputStream_FlushBeforeRetrieve_o_Map.cleanUpUnnecessaryMappings();
		collected += ByteArrayOutputStream_FlushBeforeRetrieve_b_o_Map.cleanUpUnnecessaryMappings();
		collected += ListIterator_hasNextPrevious_i_Map.cleanUpUnnecessaryMappings();
		return collected;
	}

	// Removing terminated monitors from partitioned sets
	static {
		TerminatedMonitorCleaner.start() ;
	}
	// Setting the behavior of the runtime library according to the compile-time option
	static {
		RuntimeOption.enableFineGrainedLock(false) ;
	}

	public static final void ByteArrayOutputStream_FlushBeforeRetrieve_outputstreaminitEvent(ByteArrayOutputStream b, OutputStream o) {
		ByteArrayOutputStream_FlushBeforeRetrieve_activated = true;
		while (!MultiSpec_1_RVMLock.tryLock()) {
			Thread.yield();
		}

		CachedWeakReference wr_b = null;
		CachedWeakReference wr_o = null;
		MapOfMonitor<ByteArrayOutputStream_FlushBeforeRetrieveMonitor> matchedLastMap = null;
		ByteArrayOutputStream_FlushBeforeRetrieveMonitor matchedEntry = null;
		boolean cachehit = false;
		if (((b == ByteArrayOutputStream_FlushBeforeRetrieve_b_o_Map_cachekey_b) && (o == ByteArrayOutputStream_FlushBeforeRetrieve_b_o_Map_cachekey_o) ) ) {
			matchedEntry = ByteArrayOutputStream_FlushBeforeRetrieve_b_o_Map_cachevalue;
			cachehit = true;
		}
		else {
			wr_b = new CachedWeakReference(b) ;
			wr_o = new CachedWeakReference(o) ;
			{
				// FindOrCreateEntry
				Tuple2<MapOfMonitor<ByteArrayOutputStream_FlushBeforeRetrieveMonitor>, ByteArrayOutputStream_FlushBeforeRetrieveMonitor_Set> node_b = ByteArrayOutputStream_FlushBeforeRetrieve_b_o_Map.getNodeEquivalent(wr_b) ;
				if ((node_b == null) ) {
					node_b = new Tuple2<MapOfMonitor<ByteArrayOutputStream_FlushBeforeRetrieveMonitor>, ByteArrayOutputStream_FlushBeforeRetrieveMonitor_Set>() ;
					ByteArrayOutputStream_FlushBeforeRetrieve_b_o_Map.putNode(wr_b, node_b) ;
					node_b.setValue1(new MapOfMonitor<ByteArrayOutputStream_FlushBeforeRetrieveMonitor>(1) ) ;
					node_b.setValue2(new ByteArrayOutputStream_FlushBeforeRetrieveMonitor_Set() ) ;
				}
				MapOfMonitor<ByteArrayOutputStream_FlushBeforeRetrieveMonitor> itmdMap = node_b.getValue1() ;
				matchedLastMap = itmdMap;
				ByteArrayOutputStream_FlushBeforeRetrieveMonitor node_b_o = node_b.getValue1() .getNodeEquivalent(wr_o) ;
				matchedEntry = node_b_o;
			}
		}
		// D(X) main:1
		if ((matchedEntry == null) ) {
			if ((wr_b == null) ) {
				wr_b = new CachedWeakReference(b) ;
			}
			if ((wr_o == null) ) {
				wr_o = new CachedWeakReference(o) ;
			}
			// D(X) main:4
			ByteArrayOutputStream_FlushBeforeRetrieveMonitor created = new ByteArrayOutputStream_FlushBeforeRetrieveMonitor() ;
			matchedEntry = created;
			matchedLastMap.putNode(wr_o, created) ;
			// D(X) defineNew:5 for <b>
			{
				// InsertMonitor
				Tuple2<MapOfMonitor<ByteArrayOutputStream_FlushBeforeRetrieveMonitor>, ByteArrayOutputStream_FlushBeforeRetrieveMonitor_Set> node_b = ByteArrayOutputStream_FlushBeforeRetrieve_b_o_Map.getNodeEquivalent(wr_b) ;
				if ((node_b == null) ) {
					node_b = new Tuple2<MapOfMonitor<ByteArrayOutputStream_FlushBeforeRetrieveMonitor>, ByteArrayOutputStream_FlushBeforeRetrieveMonitor_Set>() ;
					ByteArrayOutputStream_FlushBeforeRetrieve_b_o_Map.putNode(wr_b, node_b) ;
					node_b.setValue1(new MapOfMonitor<ByteArrayOutputStream_FlushBeforeRetrieveMonitor>(1) ) ;
					node_b.setValue2(new ByteArrayOutputStream_FlushBeforeRetrieveMonitor_Set() ) ;
				}
				ByteArrayOutputStream_FlushBeforeRetrieveMonitor_Set targetSet = node_b.getValue2() ;
				targetSet.add(created) ;
			}
			// D(X) defineNew:5 for <o>
			{
				// InsertMonitor
				ByteArrayOutputStream_FlushBeforeRetrieveMonitor_Set node_o = ByteArrayOutputStream_FlushBeforeRetrieve_o_Map.getNodeEquivalent(wr_o) ;
				if ((node_o == null) ) {
					node_o = new ByteArrayOutputStream_FlushBeforeRetrieveMonitor_Set() ;
					ByteArrayOutputStream_FlushBeforeRetrieve_o_Map.putNode(wr_o, node_o) ;
				}
				node_o.add(created) ;
			}
		}
		// D(X) main:8--9
		final ByteArrayOutputStream_FlushBeforeRetrieveMonitor matchedEntryfinalMonitor = matchedEntry;
		matchedEntry.Prop_1_event_outputstreaminit(b, o);
		if(matchedEntryfinalMonitor.ByteArrayOutputStream_FlushBeforeRetrieveMonitor_Prop_1_Category_fail) {
			matchedEntryfinalMonitor.Prop_1_handler_fail();
		}

		if ((cachehit == false) ) {
			ByteArrayOutputStream_FlushBeforeRetrieve_b_o_Map_cachekey_b = b;
			ByteArrayOutputStream_FlushBeforeRetrieve_b_o_Map_cachekey_o = o;
			ByteArrayOutputStream_FlushBeforeRetrieve_b_o_Map_cachevalue = matchedEntry;
		}

		MultiSpec_1_RVMLock.unlock();
	}

	public static final void ByteArrayOutputStream_FlushBeforeRetrieve_writeEvent(OutputStream o) {
		while (!MultiSpec_1_RVMLock.tryLock()) {
			Thread.yield();
		}

		if (ByteArrayOutputStream_FlushBeforeRetrieve_activated) {
			ByteArrayOutputStream_FlushBeforeRetrieveMonitor_Set matchedEntry = null;
			boolean cachehit = false;
			if ((o == ByteArrayOutputStream_FlushBeforeRetrieve_o_Map_cachekey_o) ) {
				matchedEntry = ByteArrayOutputStream_FlushBeforeRetrieve_o_Map_cachevalue;
				cachehit = true;
			}
			else {
				// FindEntry
				ByteArrayOutputStream_FlushBeforeRetrieveMonitor_Set node_o = ByteArrayOutputStream_FlushBeforeRetrieve_o_Map.getNodeWithStrongRef(o) ;
				if ((node_o != null) ) {
					matchedEntry = node_o;
				}
			}
			// D(X) main:8--9
			if ((matchedEntry != null) ) {
				matchedEntry.event_write(o);

				if ((cachehit == false) ) {
					ByteArrayOutputStream_FlushBeforeRetrieve_o_Map_cachekey_o = o;
					ByteArrayOutputStream_FlushBeforeRetrieve_o_Map_cachevalue = matchedEntry;
				}
			}

		}

		MultiSpec_1_RVMLock.unlock();
	}

	public static final void ByteArrayOutputStream_FlushBeforeRetrieve_flushEvent(OutputStream o) {
		while (!MultiSpec_1_RVMLock.tryLock()) {
			Thread.yield();
		}

		if (ByteArrayOutputStream_FlushBeforeRetrieve_activated) {
			ByteArrayOutputStream_FlushBeforeRetrieveMonitor_Set matchedEntry = null;
			boolean cachehit = false;
			if ((o == ByteArrayOutputStream_FlushBeforeRetrieve_o_Map_cachekey_o) ) {
				matchedEntry = ByteArrayOutputStream_FlushBeforeRetrieve_o_Map_cachevalue;
				cachehit = true;
			}
			else {
				// FindEntry
				ByteArrayOutputStream_FlushBeforeRetrieveMonitor_Set node_o = ByteArrayOutputStream_FlushBeforeRetrieve_o_Map.getNodeWithStrongRef(o) ;
				if ((node_o != null) ) {
					matchedEntry = node_o;
				}
			}
			// D(X) main:8--9
			if ((matchedEntry != null) ) {
				matchedEntry.event_flush(o);

				if ((cachehit == false) ) {
					ByteArrayOutputStream_FlushBeforeRetrieve_o_Map_cachekey_o = o;
					ByteArrayOutputStream_FlushBeforeRetrieve_o_Map_cachevalue = matchedEntry;
				}
			}

		}

		MultiSpec_1_RVMLock.unlock();
	}

	public static final void ByteArrayOutputStream_FlushBeforeRetrieve_closeEvent(OutputStream o) {
		while (!MultiSpec_1_RVMLock.tryLock()) {
			Thread.yield();
		}

		if (ByteArrayOutputStream_FlushBeforeRetrieve_activated) {
			ByteArrayOutputStream_FlushBeforeRetrieveMonitor_Set matchedEntry = null;
			boolean cachehit = false;
			if ((o == ByteArrayOutputStream_FlushBeforeRetrieve_o_Map_cachekey_o) ) {
				matchedEntry = ByteArrayOutputStream_FlushBeforeRetrieve_o_Map_cachevalue;
				cachehit = true;
			}
			else {
				// FindEntry
				ByteArrayOutputStream_FlushBeforeRetrieveMonitor_Set node_o = ByteArrayOutputStream_FlushBeforeRetrieve_o_Map.getNodeWithStrongRef(o) ;
				if ((node_o != null) ) {
					matchedEntry = node_o;
				}
			}
			// D(X) main:8--9
			if ((matchedEntry != null) ) {
				matchedEntry.event_close(o);

				if ((cachehit == false) ) {
					ByteArrayOutputStream_FlushBeforeRetrieve_o_Map_cachekey_o = o;
					ByteArrayOutputStream_FlushBeforeRetrieve_o_Map_cachevalue = matchedEntry;
				}
			}

		}

		MultiSpec_1_RVMLock.unlock();
	}

	public static final void ByteArrayOutputStream_FlushBeforeRetrieve_tobytearrayEvent(ByteArrayOutputStream b) {
		while (!MultiSpec_1_RVMLock.tryLock()) {
			Thread.yield();
		}

		if (ByteArrayOutputStream_FlushBeforeRetrieve_activated) {
			Tuple2<MapOfMonitor<ByteArrayOutputStream_FlushBeforeRetrieveMonitor>, ByteArrayOutputStream_FlushBeforeRetrieveMonitor_Set> matchedEntry = null;
			boolean cachehit = false;
			if ((b == ByteArrayOutputStream_FlushBeforeRetrieve_b_Map_cachekey_b) ) {
				matchedEntry = ByteArrayOutputStream_FlushBeforeRetrieve_b_Map_cachevalue;
				cachehit = true;
			}
			else {
				// FindEntry
				Tuple2<MapOfMonitor<ByteArrayOutputStream_FlushBeforeRetrieveMonitor>, ByteArrayOutputStream_FlushBeforeRetrieveMonitor_Set> node_b = ByteArrayOutputStream_FlushBeforeRetrieve_b_o_Map.getNodeWithStrongRef(b) ;
				if ((node_b != null) ) {
					matchedEntry = node_b;
				}
			}
			// D(X) main:8--9
			if ((matchedEntry != null) ) {
				ByteArrayOutputStream_FlushBeforeRetrieveMonitor_Set stateTransitionedSet = matchedEntry.getValue2() ;
				if ((stateTransitionedSet != null) ) {
					stateTransitionedSet.event_tobytearray(b);

					if ((cachehit == false) ) {
						ByteArrayOutputStream_FlushBeforeRetrieve_b_Map_cachekey_b = b;
						ByteArrayOutputStream_FlushBeforeRetrieve_b_Map_cachevalue = matchedEntry;
					}
				}
			}

		}

		MultiSpec_1_RVMLock.unlock();
	}

	public static final void ByteArrayOutputStream_FlushBeforeRetrieve_tostringEvent(ByteArrayOutputStream b) {
		while (!MultiSpec_1_RVMLock.tryLock()) {
			Thread.yield();
		}

		if (ByteArrayOutputStream_FlushBeforeRetrieve_activated) {
			Tuple2<MapOfMonitor<ByteArrayOutputStream_FlushBeforeRetrieveMonitor>, ByteArrayOutputStream_FlushBeforeRetrieveMonitor_Set> matchedEntry = null;
			boolean cachehit = false;
			if ((b == ByteArrayOutputStream_FlushBeforeRetrieve_b_Map_cachekey_b) ) {
				matchedEntry = ByteArrayOutputStream_FlushBeforeRetrieve_b_Map_cachevalue;
				cachehit = true;
			}
			else {
				// FindEntry
				Tuple2<MapOfMonitor<ByteArrayOutputStream_FlushBeforeRetrieveMonitor>, ByteArrayOutputStream_FlushBeforeRetrieveMonitor_Set> node_b = ByteArrayOutputStream_FlushBeforeRetrieve_b_o_Map.getNodeWithStrongRef(b) ;
				if ((node_b != null) ) {
					matchedEntry = node_b;
				}
			}
			// D(X) main:8--9
			if ((matchedEntry != null) ) {
				ByteArrayOutputStream_FlushBeforeRetrieveMonitor_Set stateTransitionedSet = matchedEntry.getValue2() ;
				if ((stateTransitionedSet != null) ) {
					stateTransitionedSet.event_tostring(b);

					if ((cachehit == false) ) {
						ByteArrayOutputStream_FlushBeforeRetrieve_b_Map_cachekey_b = b;
						ByteArrayOutputStream_FlushBeforeRetrieve_b_Map_cachevalue = matchedEntry;
					}
				}
			}

		}

		MultiSpec_1_RVMLock.unlock();
	}

	public static final void ListIterator_hasNextPrevious_hasnexttrueEvent(ListIterator i, boolean b) {
		ListIterator_hasNextPrevious_activated = true;
		while (!MultiSpec_1_RVMLock.tryLock()) {
			Thread.yield();
		}

		CachedWeakReference wr_i = null;
		MapOfMonitor<ListIterator_hasNextPreviousMonitor> matchedLastMap = null;
		ListIterator_hasNextPreviousMonitor matchedEntry = null;
		boolean cachehit = false;
		if ((i == ListIterator_hasNextPrevious_i_Map_cachekey_i) ) {
			matchedEntry = ListIterator_hasNextPrevious_i_Map_cachevalue;
			cachehit = true;
		}
		else {
			wr_i = new CachedWeakReference(i) ;
			{
				// FindOrCreateEntry
				MapOfMonitor<ListIterator_hasNextPreviousMonitor> itmdMap = ListIterator_hasNextPrevious_i_Map;
				matchedLastMap = itmdMap;
				ListIterator_hasNextPreviousMonitor node_i = ListIterator_hasNextPrevious_i_Map.getNodeEquivalent(wr_i) ;
				matchedEntry = node_i;
			}
		}
		// D(X) main:1
		if ((matchedEntry == null) ) {
			if ((wr_i == null) ) {
				wr_i = new CachedWeakReference(i) ;
			}
			// D(X) main:4
			ListIterator_hasNextPreviousMonitor created = new ListIterator_hasNextPreviousMonitor() ;
			matchedEntry = created;
			matchedLastMap.putNode(wr_i, created) ;
		}
		// D(X) main:8--9
		final ListIterator_hasNextPreviousMonitor matchedEntryfinalMonitor = matchedEntry;
		matchedEntry.Prop_1_event_hasnexttrue(i, b);
		if(matchedEntryfinalMonitor.ListIterator_hasNextPreviousMonitor_Prop_1_Category_fail) {
			matchedEntryfinalMonitor.Prop_1_handler_fail();
		}

		if ((cachehit == false) ) {
			ListIterator_hasNextPrevious_i_Map_cachekey_i = i;
			ListIterator_hasNextPrevious_i_Map_cachevalue = matchedEntry;
		}

		MultiSpec_1_RVMLock.unlock();
	}

	public static final void ListIterator_hasNextPrevious_hasnextfalseEvent(ListIterator i, boolean b) {
		ListIterator_hasNextPrevious_activated = true;
		while (!MultiSpec_1_RVMLock.tryLock()) {
			Thread.yield();
		}

		CachedWeakReference wr_i = null;
		MapOfMonitor<ListIterator_hasNextPreviousMonitor> matchedLastMap = null;
		ListIterator_hasNextPreviousMonitor matchedEntry = null;
		boolean cachehit = false;
		if ((i == ListIterator_hasNextPrevious_i_Map_cachekey_i) ) {
			matchedEntry = ListIterator_hasNextPrevious_i_Map_cachevalue;
			cachehit = true;
		}
		else {
			wr_i = new CachedWeakReference(i) ;
			{
				// FindOrCreateEntry
				MapOfMonitor<ListIterator_hasNextPreviousMonitor> itmdMap = ListIterator_hasNextPrevious_i_Map;
				matchedLastMap = itmdMap;
				ListIterator_hasNextPreviousMonitor node_i = ListIterator_hasNextPrevious_i_Map.getNodeEquivalent(wr_i) ;
				matchedEntry = node_i;
			}
		}
		// D(X) main:1
		if ((matchedEntry == null) ) {
			if ((wr_i == null) ) {
				wr_i = new CachedWeakReference(i) ;
			}
			// D(X) main:4
			ListIterator_hasNextPreviousMonitor created = new ListIterator_hasNextPreviousMonitor() ;
			matchedEntry = created;
			matchedLastMap.putNode(wr_i, created) ;
		}
		// D(X) main:8--9
		final ListIterator_hasNextPreviousMonitor matchedEntryfinalMonitor = matchedEntry;
		matchedEntry.Prop_1_event_hasnextfalse(i, b);
		if(matchedEntryfinalMonitor.ListIterator_hasNextPreviousMonitor_Prop_1_Category_fail) {
			matchedEntryfinalMonitor.Prop_1_handler_fail();
		}

		if ((cachehit == false) ) {
			ListIterator_hasNextPrevious_i_Map_cachekey_i = i;
			ListIterator_hasNextPrevious_i_Map_cachevalue = matchedEntry;
		}

		MultiSpec_1_RVMLock.unlock();
	}

	public static final void ListIterator_hasNextPrevious_nextEvent(ListIterator i) {
		ListIterator_hasNextPrevious_activated = true;
		while (!MultiSpec_1_RVMLock.tryLock()) {
			Thread.yield();
		}

		CachedWeakReference wr_i = null;
		MapOfMonitor<ListIterator_hasNextPreviousMonitor> matchedLastMap = null;
		ListIterator_hasNextPreviousMonitor matchedEntry = null;
		boolean cachehit = false;
		if ((i == ListIterator_hasNextPrevious_i_Map_cachekey_i) ) {
			matchedEntry = ListIterator_hasNextPrevious_i_Map_cachevalue;
			cachehit = true;
		}
		else {
			wr_i = new CachedWeakReference(i) ;
			{
				// FindOrCreateEntry
				MapOfMonitor<ListIterator_hasNextPreviousMonitor> itmdMap = ListIterator_hasNextPrevious_i_Map;
				matchedLastMap = itmdMap;
				ListIterator_hasNextPreviousMonitor node_i = ListIterator_hasNextPrevious_i_Map.getNodeEquivalent(wr_i) ;
				matchedEntry = node_i;
			}
		}
		// D(X) main:1
		if ((matchedEntry == null) ) {
			if ((wr_i == null) ) {
				wr_i = new CachedWeakReference(i) ;
			}
			// D(X) main:4
			ListIterator_hasNextPreviousMonitor created = new ListIterator_hasNextPreviousMonitor() ;
			matchedEntry = created;
			matchedLastMap.putNode(wr_i, created) ;
		}
		// D(X) main:8--9
		final ListIterator_hasNextPreviousMonitor matchedEntryfinalMonitor = matchedEntry;
		matchedEntry.Prop_1_event_next(i);
		if(matchedEntryfinalMonitor.ListIterator_hasNextPreviousMonitor_Prop_1_Category_fail) {
			matchedEntryfinalMonitor.Prop_1_handler_fail();
		}

		if ((cachehit == false) ) {
			ListIterator_hasNextPrevious_i_Map_cachekey_i = i;
			ListIterator_hasNextPrevious_i_Map_cachevalue = matchedEntry;
		}

		MultiSpec_1_RVMLock.unlock();
	}

	public static final void ListIterator_hasNextPrevious_hasprevioustrueEvent(ListIterator i, boolean b) {
		ListIterator_hasNextPrevious_activated = true;
		while (!MultiSpec_1_RVMLock.tryLock()) {
			Thread.yield();
		}

		CachedWeakReference wr_i = null;
		MapOfMonitor<ListIterator_hasNextPreviousMonitor> matchedLastMap = null;
		ListIterator_hasNextPreviousMonitor matchedEntry = null;
		boolean cachehit = false;
		if ((i == ListIterator_hasNextPrevious_i_Map_cachekey_i) ) {
			matchedEntry = ListIterator_hasNextPrevious_i_Map_cachevalue;
			cachehit = true;
		}
		else {
			wr_i = new CachedWeakReference(i) ;
			{
				// FindOrCreateEntry
				MapOfMonitor<ListIterator_hasNextPreviousMonitor> itmdMap = ListIterator_hasNextPrevious_i_Map;
				matchedLastMap = itmdMap;
				ListIterator_hasNextPreviousMonitor node_i = ListIterator_hasNextPrevious_i_Map.getNodeEquivalent(wr_i) ;
				matchedEntry = node_i;
			}
		}
		// D(X) main:1
		if ((matchedEntry == null) ) {
			if ((wr_i == null) ) {
				wr_i = new CachedWeakReference(i) ;
			}
			// D(X) main:4
			ListIterator_hasNextPreviousMonitor created = new ListIterator_hasNextPreviousMonitor() ;
			matchedEntry = created;
			matchedLastMap.putNode(wr_i, created) ;
		}
		// D(X) main:8--9
		final ListIterator_hasNextPreviousMonitor matchedEntryfinalMonitor = matchedEntry;
		matchedEntry.Prop_1_event_hasprevioustrue(i, b);
		if(matchedEntryfinalMonitor.ListIterator_hasNextPreviousMonitor_Prop_1_Category_fail) {
			matchedEntryfinalMonitor.Prop_1_handler_fail();
		}

		if ((cachehit == false) ) {
			ListIterator_hasNextPrevious_i_Map_cachekey_i = i;
			ListIterator_hasNextPrevious_i_Map_cachevalue = matchedEntry;
		}

		MultiSpec_1_RVMLock.unlock();
	}

	public static final void ListIterator_hasNextPrevious_haspreviousfalseEvent(ListIterator i, boolean b) {
		ListIterator_hasNextPrevious_activated = true;
		while (!MultiSpec_1_RVMLock.tryLock()) {
			Thread.yield();
		}

		CachedWeakReference wr_i = null;
		MapOfMonitor<ListIterator_hasNextPreviousMonitor> matchedLastMap = null;
		ListIterator_hasNextPreviousMonitor matchedEntry = null;
		boolean cachehit = false;
		if ((i == ListIterator_hasNextPrevious_i_Map_cachekey_i) ) {
			matchedEntry = ListIterator_hasNextPrevious_i_Map_cachevalue;
			cachehit = true;
		}
		else {
			wr_i = new CachedWeakReference(i) ;
			{
				// FindOrCreateEntry
				MapOfMonitor<ListIterator_hasNextPreviousMonitor> itmdMap = ListIterator_hasNextPrevious_i_Map;
				matchedLastMap = itmdMap;
				ListIterator_hasNextPreviousMonitor node_i = ListIterator_hasNextPrevious_i_Map.getNodeEquivalent(wr_i) ;
				matchedEntry = node_i;
			}
		}
		// D(X) main:1
		if ((matchedEntry == null) ) {
			if ((wr_i == null) ) {
				wr_i = new CachedWeakReference(i) ;
			}
			// D(X) main:4
			ListIterator_hasNextPreviousMonitor created = new ListIterator_hasNextPreviousMonitor() ;
			matchedEntry = created;
			matchedLastMap.putNode(wr_i, created) ;
		}
		// D(X) main:8--9
		final ListIterator_hasNextPreviousMonitor matchedEntryfinalMonitor = matchedEntry;
		matchedEntry.Prop_1_event_haspreviousfalse(i, b);
		if(matchedEntryfinalMonitor.ListIterator_hasNextPreviousMonitor_Prop_1_Category_fail) {
			matchedEntryfinalMonitor.Prop_1_handler_fail();
		}

		if ((cachehit == false) ) {
			ListIterator_hasNextPrevious_i_Map_cachekey_i = i;
			ListIterator_hasNextPrevious_i_Map_cachevalue = matchedEntry;
		}

		MultiSpec_1_RVMLock.unlock();
	}

	public static final void ListIterator_hasNextPrevious_previousEvent(ListIterator i) {
		ListIterator_hasNextPrevious_activated = true;
		while (!MultiSpec_1_RVMLock.tryLock()) {
			Thread.yield();
		}

		CachedWeakReference wr_i = null;
		MapOfMonitor<ListIterator_hasNextPreviousMonitor> matchedLastMap = null;
		ListIterator_hasNextPreviousMonitor matchedEntry = null;
		boolean cachehit = false;
		if ((i == ListIterator_hasNextPrevious_i_Map_cachekey_i) ) {
			matchedEntry = ListIterator_hasNextPrevious_i_Map_cachevalue;
			cachehit = true;
		}
		else {
			wr_i = new CachedWeakReference(i) ;
			{
				// FindOrCreateEntry
				MapOfMonitor<ListIterator_hasNextPreviousMonitor> itmdMap = ListIterator_hasNextPrevious_i_Map;
				matchedLastMap = itmdMap;
				ListIterator_hasNextPreviousMonitor node_i = ListIterator_hasNextPrevious_i_Map.getNodeEquivalent(wr_i) ;
				matchedEntry = node_i;
			}
		}
		// D(X) main:1
		if ((matchedEntry == null) ) {
			if ((wr_i == null) ) {
				wr_i = new CachedWeakReference(i) ;
			}
			// D(X) main:4
			ListIterator_hasNextPreviousMonitor created = new ListIterator_hasNextPreviousMonitor() ;
			matchedEntry = created;
			matchedLastMap.putNode(wr_i, created) ;
		}
		// D(X) main:8--9
		final ListIterator_hasNextPreviousMonitor matchedEntryfinalMonitor = matchedEntry;
		matchedEntry.Prop_1_event_previous(i);
		if(matchedEntryfinalMonitor.ListIterator_hasNextPreviousMonitor_Prop_1_Category_fail) {
			matchedEntryfinalMonitor.Prop_1_handler_fail();
		}

		if ((cachehit == false) ) {
			ListIterator_hasNextPrevious_i_Map_cachekey_i = i;
			ListIterator_hasNextPrevious_i_Map_cachevalue = matchedEntry;
		}

		MultiSpec_1_RVMLock.unlock();
	}

}
