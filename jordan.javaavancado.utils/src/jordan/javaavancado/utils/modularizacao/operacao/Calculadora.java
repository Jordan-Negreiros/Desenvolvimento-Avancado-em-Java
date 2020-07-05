package jordan.javaavancado.utils.modularizacao.operacao;

import jordan.javaavancado.utils.modularizacao.operacao.internal.DivHelper;
import jordan.javaavancado.utils.modularizacao.operacao.internal.MultHelper;
import jordan.javaavancado.utils.modularizacao.operacao.internal.SubHelper;
import jordan.javaavancado.utils.modularizacao.operacao.internal.SumHelper;

public class Calculadora {

    private final DivHelper divHelper;
    private final MultHelper multHelper;
    private final SubHelper subHelper;
    private final SumHelper sumHelper;

    public Calculadora() {
        this.divHelper = new DivHelper();
        this.multHelper = new MultHelper();
        this.subHelper = new SubHelper();
        this.sumHelper = new SumHelper();
    }

    public int div(int a, int b) {
        return divHelper.execute(a, b);
    }

    public int mult(int a, int b) {
        return multHelper.execute(a, b);
    }

    public int sub(int a, int b) {
        return subHelper.execute(a, b);
    }

    public int sum(int a, int b) {
        return sumHelper.execute(a, b);
    }
}
