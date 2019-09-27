package com.xingyun.evendemo.moshi

import com.squareup.moshi.FromJson
import com.squareup.moshi.Moshi
import com.squareup.moshi.ToJson
import org.junit.Test

class MoshiTest {


    @Test
    fun testMoshi(){
        val json = (""
                + "{\n"
                + "  \"title\": \"Blackjack tournament\",\n"
                + "  \"begin_date\": \"20151010\",\n"
                + "  \"begin_time\": \"17:04\"\n"
                + "}\n")

        val moshi = Moshi.Builder().add(EventJsonAdapter()).build()
        val jsonAdapter = moshi.adapter(Event::class.java)

        val event = jsonAdapter.fromJson(json)
        println(event)
        println(jsonAdapter.toJson(event))
    }


}

class EventJsonAdapter {
    @FromJson
    internal fun eventFromJson(eventJson: EventJson): Event {
        val event = Event()
        event.title = eventJson.title
        event.beginDateAndTime = eventJson.begin_date + " " + eventJson.begin_time
        return event
    }

    @ToJson
    internal fun eventToJson(event: Event): EventJson {
        val json = EventJson()
        json.title = event.title
        json.begin_date = event.beginDateAndTime?.substring(0, 8)
        json.begin_time = event.beginDateAndTime?.substring(9, 14)
        return json
    }
}

class EventJson {
    internal var title: String? = null
    internal var begin_date: String? = null
    internal var begin_time: String? = null
}

class Event {
    internal var title: String? = null
    internal var beginDateAndTime: String? = null

    override fun toString(): String {
        return ("Event{"
                + "title='" + title + '\''.toString()
                + ", beginDateAndTime='" + beginDateAndTime + '\''.toString()
                + '}'.toString())
    }
}