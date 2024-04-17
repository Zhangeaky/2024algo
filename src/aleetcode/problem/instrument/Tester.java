package aleetcode.problem.instrument;

public interface Tester {


    <T, R> R testExecute(T input);
}
