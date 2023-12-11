from django.db import models

class User(models.Model):
    #userId, fakeId, role
    userId = models.CharField(max_length=10, null = False)
    username = models.CharField(max_length=10, null = False)
    fakeId = models.CharField(max_length=10, null = False)
    role = models.BooleanField

    def __str__(self):
        return self.userId

class Report(models.Model):
    #userId, date, fromUserId, status, messId
    userId = models.CharField(max_length=10, null = False)
    datetime =models.DateTimeField(null = False)
    fromUserId = models.CharField(max_length=10, null = False)
    status = models.BooleanField
    messId = models.CharField(max_length=10, null = False)

    def __str__(self):
        return self.userId


