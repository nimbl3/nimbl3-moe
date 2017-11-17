package chat.common.nimbl3.com.model

import java.io.Serializable

class QueryResponse : Serializable {
    var id: String? = null
    var lang: String? = null
    var result: QueryResult? = null
}

class QueryResult : Serializable {
    var actionIncomplete: Boolean = false
    val speech: String = ""
    val fulfillment: Fulfillment = Fulfillment()
}

class Fulfillment : Serializable {
    var speech: String? = null
    var messages: List<Message>? = null
}

class Message : Serializable {
    var type: String? = null
    var textToSpeech: String? = null
    var suggestions: List<String>? = null
    var speech: String? = null
}
