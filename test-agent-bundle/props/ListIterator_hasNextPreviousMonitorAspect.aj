package mop;
import java.util.*;
import com.runtimeverification.rvmonitor.java.rt.RVMLogging;
import com.runtimeverification.rvmonitor.java.rt.RVMLogging.Level;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

import java.lang.ref.*;
import org.aspectj.lang.*;

public aspect ListIterator_hasNextPreviousMonitorAspect implements com.runtimeverification.rvmonitor.java.rt.RVMObject {
	public ListIterator_hasNextPreviousMonitorAspect(){
	}

	// Declarations for the Lock
	static ReentrantLock ListIterator_hasNextPrevious_MOPLock = new ReentrantLock();
	static Condition ListIterator_hasNextPrevious_MOPLock_cond = ListIterator_hasNextPrevious_MOPLock.newCondition();

	pointcut MOP_CommonPointCut() : !within(com.runtimeverification.rvmonitor.java.rt.RVMObject+) && !adviceexecution() && BaseAspect.notwithin();
	pointcut ListIterator_hasNextPrevious_previous(ListIterator i) : (call(* ListIterator.previous()) && target(i)) && MOP_CommonPointCut();
	before (ListIterator i) : ListIterator_hasNextPrevious_previous(i) {
		MultiSpec_1RuntimeMonitor.ListIterator_hasNextPrevious_previousEvent(i);
	}

	pointcut ListIterator_hasNextPrevious_next(ListIterator i) : (call(* ListIterator.next()) && target(i)) && MOP_CommonPointCut();
	before (ListIterator i) : ListIterator_hasNextPrevious_next(i) {
		MultiSpec_1RuntimeMonitor.ListIterator_hasNextPrevious_nextEvent(i);
	}

	pointcut ListIterator_hasNextPrevious_hasnexttrue(ListIterator i) : (call(* ListIterator.hasNext()) && target(i)) && MOP_CommonPointCut();
	after (ListIterator i) returning (boolean b) : ListIterator_hasNextPrevious_hasnexttrue(i) {
		//ListIterator_hasNextPrevious_hasnexttrue
		MultiSpec_1RuntimeMonitor.ListIterator_hasNextPrevious_hasnexttrueEvent(i, b);
		//ListIterator_hasNextPrevious_hasnextfalse
		MultiSpec_1RuntimeMonitor.ListIterator_hasNextPrevious_hasnextfalseEvent(i, b);
	}

	pointcut ListIterator_hasNextPrevious_hasprevioustrue(ListIterator i) : (call(* ListIterator.hasPrevious()) && target(i)) && MOP_CommonPointCut();
	after (ListIterator i) returning (boolean b) : ListIterator_hasNextPrevious_hasprevioustrue(i) {
		//ListIterator_hasNextPrevious_hasprevioustrue
		MultiSpec_1RuntimeMonitor.ListIterator_hasNextPrevious_hasprevioustrueEvent(i, b);
		//ListIterator_hasNextPrevious_haspreviousfalse
		MultiSpec_1RuntimeMonitor.ListIterator_hasNextPrevious_haspreviousfalseEvent(i, b);
	}

}
