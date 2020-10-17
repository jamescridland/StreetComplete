package de.westnordost.streetcomplete.quests.surface

import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import de.westnordost.streetcomplete.R

class DescribeGenericSurfaceDialog(
    context: Context,
    onSurfaceDescribed: (txt:String) -> Unit
) : AlertDialog(context, R.style.Theme_Bubble_Dialog) {
    init {
        val view = LayoutInflater.from(context).inflate(R.layout.quest_surface_detailed_answer_impossible, null)
        val explanationInput = view.findViewById<EditText>(R.id.explanationInput)
        // TODO enable/disable ok button based on whether commentInput is empty (with TextWatcher?)

        setTitle(context.resources.getString(R.string.quest_surface_detailed_answer_impossible_title))

        setButton(
            DialogInterface.BUTTON_POSITIVE,
            context.getString(android.R.string.yes)
        ) { _, _ ->
            val txt = explanationInput.text.toString().trim()
            if (txt.isNotEmpty()) {
                onSurfaceDescribed(txt)
            }
        }

        setButton(
            DialogInterface.BUTTON_NEGATIVE,
            context.getString(android.R.string.cancel)
        ) { _, _ ->
            setView(view)
        }
        setView(view)
    }
}
