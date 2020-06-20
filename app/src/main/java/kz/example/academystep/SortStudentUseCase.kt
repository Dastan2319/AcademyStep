package kz.example.academystep

class  SortStudentUseCase {
    fun sortByName(students:List<String> ):List<String>? {
        var result= students.sortedBy { it }
        return result;
    }
    fun sortRandom(students:List<String> ):List<String> {
        var answer = students.shuffled();
        return answer;
    }
}