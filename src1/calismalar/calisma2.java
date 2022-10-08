package calismalar;

public class calisma2 {
	String[] students = new String[10];
	String studentName = "Peter Parker";
	students[0] = studentName;
	studentName = null;

	Bu kodların icra edilməsindən sonra neçə ədəd reference olacaq? və neçə obyekt GC tərəfindən silinəcək?
			evvelde 2 reference(students birde studentName) var sonra 2 reference(students birde studentName) qaldi
			sonra "Peter Parker" obyekti gc terefinden silinir
}
