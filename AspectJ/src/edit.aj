public aspect edit {
	declare precedence:  *,edit,show;
	void around() : execution(* *..TextEditView.initial(..)){
	}
}
