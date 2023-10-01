import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {

        App app = new App();
        QuadraticEquationSolver solver = app.new QuadraticEquationSolverImpl();
        solver.solve(1, -6, 9);// Приклад виклику

    }
    public abstract class QuadraticEquationSolver {
        // Шаблонний метод для знаходження дискримінанта та коренів рівняння
        public void solve(double a, double b, double c) {
            double D = calculateDiscriminant(a, b, c);

            if (D > 0) {
                double x1 = (-b + Math.sqrt(D)) / (2 * a);
                double x2 = (-b - Math.sqrt(D)) / (2 * a);
                displayRoots(x1, x2);
            } else if (D == 0) {
                double x = -b / (2 * a);
                displayRoot(x);
            } else {
                displayNoRoots();
            }
        }

        // Абстрактні методи, які мають бути реалізовані підкласами
        protected abstract double calculateDiscriminant(double a, double b, double c);
        protected abstract void displayRoots(double x1, double x2);
        protected abstract void displayRoot(double x);
        protected abstract void displayNoRoots();
    }

    public class QuadraticEquationSolverImpl extends QuadraticEquationSolver {
        @Override
        protected double calculateDiscriminant(double a, double b, double c) {
            return Math.pow(b,2) - 4 * a * c;
        }

        @Override
        protected void displayRoots(double x1, double x2) {
            System.out.println("Рівняння має два корені:");
            System.out.println("x1: " + x1);
            System.out.println("x2: " + x2);
        }

        @Override
        protected void displayRoot(double x) {
            System.out.println("Рівняння має один корінь:");
            System.out.println("x: " + x);
        }

        @Override
        protected void displayNoRoots() {
            System.out.println("Error");
        }
    }


}
