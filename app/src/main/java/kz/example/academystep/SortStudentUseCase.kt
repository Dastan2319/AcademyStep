package kz.example.academystep

class  SortStudentUseCase {
    fun sortByName(students:ArrayList<String> ) {
        val result = students.sort();
        return result;
    }
    fun sortRandom(students:ArrayList<String> ) {
        val result =students.shuffle();
        return result;
    }
}