
public class Declaration implements Constante {
    private String lastIdent;
    private TabIdent tabIdent;
    private eType lastType;
    public int offset;

    public Declaration(TabIdent tabIdent) {
        this.tabIdent = tabIdent;
        this.offset = 0;
    }

    public void createConstInt(int v, int line) {
        if(tabIdent.existeIdent(lastIdent))
            System.out.println("Erreur: l'ident '" + lastIdent + "' existe deja (ligne:" + line + ").");
        tabIdent.rangeIdent(lastIdent, new IdConst(lastIdent, Constante.eType.ENTIER, v));
    }

    public void createConstBool(int b, int line) {
        if(tabIdent.existeIdent(lastIdent))
            System.out.println("Erreur: l'ident '" + lastIdent + "' existe deja (ligne:" + line + ").");
        tabIdent.rangeIdent(lastIdent, new IdConst(lastIdent, Constante.eType.BOOLEEN, b));
    }

    public void appelConst(String ident, int line){
    	if(!tabIdent.existeIdent(ident))
    		System.out.println("Erreur, l'ident" + ident + "n'existe pas, erreur à la ligne" + line +".");
    	Ident i = tabIdent.chercheIdent(ident);
    	int a = i.getValeur();
    	Yaka.yvm.iconst(a); 
    }
    
    public void createConstVar(String ident, int line) {
        if(!tabIdent.existeIdent(ident))
            System.out.println("Erreur: l'ident '" + ident + "' n'existe pas (ligne:" + line + ").");
        else {
            Ident id = tabIdent.chercheIdent(ident);
            if(id.getType() == Constante.eType.BOOLEEN)
                createConstBool(id.getValeur(), line);
            else
                createConstInt(id.getValeur(), line);
        }
    }

    public void createVar(String name, int line) {
        if(tabIdent.existeIdent(name))
            System.out.println("Erreur: l'ident '" + name + "' existe deja (ligne:" + line + ").");
        offset -= 2;
        tabIdent.rangeIdent(name, new IdVar(name, lastType, offset));
        System.out.println();
    }

    public String getLastIdent() {
        return lastIdent;
    }

    public void setLastIdent(String lastIdent) {
        this.lastIdent = lastIdent;
    }

    public eType getLastType() {
        return lastType;
    }

    public void setLastType(eType lastType) {
        this.lastType = lastType;
    }

    public String toString() {
        String s = "";
        for(String key : tabIdent.getTable().keySet()){
            s += key + "\t" + tabIdent.getTable().get(key).getType().toString() + "\t" + tabIdent.getTable().get(key).getValeur() + "\n";
        }
        return s;
    }
}
