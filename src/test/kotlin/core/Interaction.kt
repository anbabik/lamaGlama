package core

import com.codeborne.selenide.SelenideElement

class Interaction {

   companion object {
       fun setInputValue(element: SelenideElement, value: String) {
           element.value = value
       }
   }

}
