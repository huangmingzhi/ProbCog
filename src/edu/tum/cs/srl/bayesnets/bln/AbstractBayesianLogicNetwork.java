package edu.tum.cs.srl.bayesnets.bln;


import edu.tum.cs.inference.IParameterHandler;
import edu.tum.cs.inference.ParameterHandler;
import edu.tum.cs.srl.Database;
import edu.tum.cs.srl.bayesnets.ABLModel;
import edu.tum.cs.srl.bayesnets.RelationalBeliefNetwork;

public abstract class AbstractBayesianLogicNetwork extends ABLModel implements IParameterHandler {
	public RelationalBeliefNetwork rbn;
	public String logicFile;
	protected ParameterHandler paramHandler;
	
	public AbstractBayesianLogicNetwork(String declsFile, String networkFile, String logicFile) throws Exception {
		super(declsFile, networkFile);
		this.logicFile = logicFile;
		this.paramHandler = new ParameterHandler(this);
		this.rbn = this;
	}
	
	public AbstractBayesianLogicNetwork(String declsFile) throws Exception {
		super(declsFile);
		this.paramHandler = new ParameterHandler(this);
		this.rbn = this;
	}
	
	public abstract AbstractGroundBLN ground(Database db) throws Exception;
	
	public ParameterHandler getParameterHandler() {
		return paramHandler;
	}
}
