#############update webpoll/question_details.html #######################
<!DOCTYPE html>

<h2>{{ question.questionname }}</h2>

<form>

{% for choice in question.choice_set.all %}
{% endfor %}
<input type="submit" value="Submit Vote" />
</form>




#############update webpoll/home.html#######################
<!DOCTYPE html>
{% if recent_question_list %}
    <ul>
    {% for question in recent_question_list %}
        <li><a href="{% url 'webpoll:detail' question.id %}">{{ question.questionname }}</a></li>
    {% endfor %}
    </ul>
{% else %}
    <p>Questions not available for polling!</p>
{% endif %}



#############update webpoll/views #######################

from django.views import generic
from django.utils import timezone
from django.shortcuts import get_object_or_404,render
from django.http import HttpResponse

from .models import question,choice

class HomeView(generic.ListView):
    template_name='webpoll/home.html'
    context_object_name='recent_question_list'
    def get_queryset(self):
        return question.objects.filter(pubdate__lte=timezone.now()).order_by('-pubdate')[:6]

class QuestionDetailView(generic.DetailView):
    model=question
    template_name='webpoll/question_detail.html'
    def get_queryset(self):
        return question.objects.filter(pubdate__lte=timezone.now())






#############update webpoll/urls#######################
from django.conf.urls import url,include
from . import views

app_name='webpoll'
urlpatterns=[
    url(r'^$', views.HomeView.as_view(), name='home'),
    url(r'^(?P<pk>[0-9]+)/$',views.QuestionDetailView.as_view(),name='detail'),
    ]