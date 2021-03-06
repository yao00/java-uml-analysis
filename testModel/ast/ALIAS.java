package ast;

import java.util.ArrayList;
import java.util.List;

public class ALIAS extends STATEMENT {
    private final List<PROGRAM> programs = new ArrayList<>();
    private String newName;

    private String oldName;

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public String getOldName() {
        return oldName;
    }

    public void setOldName(String oldName) {
        this.oldName = oldName;
    }

    @Override
    public void parse() {
        tokenizer.getAndCheckNext("alias");
        setNewName(tokenizer.getNext());
        tokenizer.getAndCheckNext(",");
        setOldName(tokenizer.getNext());
    }

    @Override
    public <T> T accept(tinyVarsVisitor<T> v) {
        return v.visit(this);
    }
}
