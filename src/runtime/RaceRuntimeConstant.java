package runtime;

public interface RaceRuntimeConstant {
	public static final String FOR_LOOP_START = "FOR_LOOP_START";
	public static final String FOR_LOOP_END = "FOR_LOOP_END";
	public static final String COMPARISION_START = "COMPARISION_START";
	public static final String COMPARISION_END = "COMPARISION_END";

	public static final String ACC_REGISTER = "REG";
	public static final String C_REGISTER = "C";
	public static final String B_REGISTER = "B";

	public static final String STORE_INSTRUCTION = "SAVE";
	public static final String READ_INSTRUCTION = "READ";
	public static final String WRITE_INSTRUCTION = "DISPLAY";

	public static final String ADD_INSTRUCTION = "ADD";
	public static final String SUBTRACT_INSTRUCTION = "SUB";
	public static final String MULTIPLY_INSTRUCTION = "MUL";
	public static final String DIVIDE_INSTRUCTION = "DIV";

	public static final String UNARY_MINUS = "UNARY";

	public static final String GREATER_THAN = "GREATER";
	public static final String GREATER_THAN_EQUAL = "GREATER_OR_EQUAL";
	public static final String LESS_THAN = "LESSER";
	public static final String LESS_THAN_EQUAL= "LESSER_OR_EQUAL";
	public static final String EQUAL_EQUAL = "EQUAL_TO";
	public static final String NOT_EQUAL = "NOT_EQUAL";

	public static final String OR = "OR";
	public static final String AND = "AND";
	public static final String NOT = "NOT";

	public static final String BOOLEAN_EQUAL_EQUAL = "BOOL_ISEQUALS";
	public static final String BOOLEAN_NOT_EQUAL = "BOOL_IS_NOT_EQUALS";

	public static final String IF_ELSE_BLOCK_START = "IF_ELSE_BLOCK_START";
	public static final String IF_ELSE_BLOCK_END = "IF_ELSE_BLOCK_END";
	public static final String IF_BLOCK_START = "IF_BLOCK_START";
	public static final String IF_BLOCK_END = "IF_BLOCK_END";
	public static final String ELSE_IF_BLOCK_START = "ELSE_IF_BLOCK_START";
	public static final String ELSE_IF_BLOCK_END = "ELSE_IF_BLOCK_END";
	public static final String ELSE_BLOCK_START = "ELSE_BLOCK_START";
	public static final String ELSE_BLOCK_END = "ELSE_BLOCK_END";

	public static final String CONDITION_START = "CONDITION_START";
	public static final String CONDITION_END = "CONDITION_END";

	public static final String WHILE_BLOCK_START = "WHILE_BLOCK_START";
	public static final String WHILE_BLOCK_END = "WHILE_BLOCK_END";


	public static final String FUNCTION_START = "FUNCTION_START";
	public static final String FUNCTION_END = "FUNCTION_END";
	public static final String FUNCTION_NAME = "FUNCTION_NAME";
	public static final String FUNCTION_PARAMS = "FUNCTION_PARAMS";
	public static final String FUNCTION_RETURN_START = "FUNCTION_RETURN_START";
	public static final String FUNCTION_RETURN_END = "FUNCTION_RETURN_END";
	public static final String FUNCTION_CALL = "FUNCTION_CALL";
}

