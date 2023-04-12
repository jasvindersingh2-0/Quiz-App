package com.example.quizapp

object Constants {
    const val USER_NAME:String="user_name"
    const val TOTAL_QUESTIONS:String="total_que"
    const val CORRECT_ANSWERS:String="correct_ans"
    fun getQuestions(): ArrayList<Questions> {
        val questionsList=ArrayList<Questions>()
        val que1 = Questions(1, "From Which Country this Flag Belong to?",
            "Argentina", "Australia", "Austria", "America",
            R.drawable.ic_flag_of_argentina,
            1)
        questionsList.add(que1)
        val que2 = Questions(2, "From Which Country this Flag Belong to?",
            "Indonesia", "Ireland", "India", "Iran",
            R.drawable.ic_flag_of_india,
            3)
        questionsList.add(que2)

        val que3 = Questions(3, "From Which Country this Flag Belong to?",
            "Argentina", "Australia", "Austria", "America",
            R.drawable.ic_flag_of_australia,
            2)
        questionsList.add(que3)
        val que4 = Questions(4, "From Which Country this Flag Belong to?",
            "Spain", "Russia", "Austria", "Germany",
            R.drawable.ic_flag_of_germany,
            4)
        questionsList.add(que4)

        val que5 = Questions(5, "From Which Country this Flag Belong to?",
            "Belgium", "Brazil", "Nepal", "Bhutan",
            R.drawable.ic_flag_of_belgium,
            1)
        questionsList.add(que5)

        val que6 = Questions(6, "From Which Country this Flag Belong to?",
            "India", "Denmark", "Indonesia", "China",
            R.drawable.ic_flag_of_denmark,
            2)
        questionsList.add(que6)

        val que7 = Questions(7, "From Which Country this Flag Belong to?",
            "Switzerland", "Brampton", "Brazil", "Kuwait",
            R.drawable.ic_flag_of_kuwait,
            4)
        questionsList.add(que7)

        val que8 = Questions(8, "From Which Country this Flag Belong to?",
            "Fiji", "China", "SriLanka", "U.A.E",
            R.drawable.ic_flag_of_fiji,
            1)
        questionsList.add(que8)
        val que9 = Questions(9, "From Which Country this Flag Belong to?",
            "NewZealand", "Australia", "England", "Austria",
            R.drawable.ic_flag_of_new_zealand,
            1)
        questionsList.add(que9)
        val que10 = Questions(10, "From Which Country this Flag Belong to?",
            "Croatia", "China", "Brazil", "West Indies",
            R.drawable.ic_flag_of_brazil,
            3)
        questionsList.add(que10)

        return questionsList
    }
}